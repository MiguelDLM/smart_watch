// HK89 Dial Decompressor - Reconstructed Version
// Extracts dial information and images from HK89 smartwatch .bin files
// Compatible with original hkdecomp v1.8

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <png.h>

#define MAX_MEMORY_SIZE 0x12C000
#define MAX_TEXT_SIZE 0x8000

static void *g_main_buffer = NULL;
static char *g_filename = NULL;
static char *g_text_buffer = NULL;
static unsigned char g_block_count = 0;
static int g_file_size = 0;
static int *g_picture_sizes = NULL;

typedef struct {
    unsigned int picture_address;   // 0x00-0x03
    unsigned char picidx;          // 0x04
    unsigned char valami2;         // 0x05
    unsigned short sx;             // 0x06-0x07
    unsigned short sy;             // 0x08-0x09
    unsigned short posX;           // 0x0A-0x0B
    unsigned short posY;           // 0x0C-0x0D
    unsigned char parts;           // 0x0E
    unsigned char blocktype;       // 0x0F
    unsigned char align;           // 0x10
    unsigned char compr;           // 0x11
    unsigned char centX;           // 0x12
    unsigned char centY;           // 0x13
} __attribute__((packed)) dial_block_t;

const char *get_block_type_name(unsigned char type) {
    switch(type) {
        case 0x81: return "Preview image";
        case 0x89: return "Hours";
        case 0x8A: return "Minutes";
        case 0x8B: return "Battery";
        case 0x8C: return "Month";
        case 0x8D: return "Day of week";
        case 0x02: return "Background image";
        case 0x06: return "Arm hour";
        case 0x07: return "Arm minute";
        case 0x82: return "Background image";
        case 0x86: return "Year";
        case 0x87: return "Month";
        case 0x88: return "Day";
        case 0x8E: return "Steps";
        case 0x98: return "Battery strip";
        default: return "Unknown";
    }
}

const char *get_block_type_format(unsigned char type) {
    switch(type) {
        case 0x81: case 0x89: case 0x8A: case 0x8B: case 0x8C: case 0x8D:
        case 0x82: case 0x86: case 0x87: case 0x88: case 0x8E: case 0x98:
            return "RGBA";
        default:
            return " RGB";
    }
}

const char *get_block_type_short_name(unsigned char type, int block_index) {
    switch(type) {
        case 0x81: return "prev";
        case 0x89: return "hours";
        case 0x8A: return "minutes";
        case 0x8B: return "battery";
        case 0x8C: return "Month";
        case 0x8D: return "";
        case 0x02: return "background2";
        case 0x06: return "arm_hour";
        case 0x07: return "arm_minute";
        case 0x82: {
            static char bg_name[20];
            snprintf(bg_name, sizeof(bg_name), "background%d", block_index);
            return bg_name;
        }
        case 0x86: return "";
        case 0x87: return "Month";
        case 0x88: return "";
        case 0x8E: return "steps";
        case 0x98: return "battery";
        default: return "unknown";
    }
}

int get_file_size(FILE *fp) {
    fseek(fp, 0, SEEK_END);
    int size = ftell(fp);
    fseek(fp, 0, SEEK_SET);
    return size;
}

void create_output_directory(const char *filename) {
    char basename[256];
    const char *base = strrchr(filename, '/');
    base = base ? base + 1 : filename;
    
    strncpy(basename, base, sizeof(basename) - 1);
    basename[sizeof(basename) - 1] = '\0';
    
    char *dot = strrchr(basename, '.');
    if (dot) *dot = '\0';
    
    char dirname[256];
    snprintf(dirname, sizeof(dirname), "_%s", basename);
    mkdir(dirname, 0755);
}

void calculate_picture_sizes() {
    if (!g_picture_sizes) {
        g_picture_sizes = calloc(256, sizeof(int));
    }
    
    dial_block_t *blocks = (dial_block_t*)((char*)g_main_buffer + 4);
    
    for (int i = 0; i < g_block_count; i++) {
        dial_block_t *block = &blocks[i];
        int start_addr = block->picture_address;
        int end_addr = g_file_size;
        
        // Find next picture address to calculate size
        for (int j = 0; j < g_block_count; j++) {
            if (blocks[j].picture_address > start_addr && blocks[j].picture_address < end_addr) {
                end_addr = blocks[j].picture_address;
            }
        }
        
        g_picture_sizes[block->picidx] = end_addr - start_addr;
    }
}

void print_picture_summary() {
    printf("Number of block = %d , (0x%04X)\n", g_block_count, g_block_count);
    
    unsigned short block_table_size = *(unsigned short*)g_main_buffer;
    printf("Size of pltable = %d , (0x%04X)\n", block_table_size, block_table_size);
    printf("\n");
    
    // Print byte sizes in rows of 8
    int total_bytes = 0;
    for (int i = 0; i < 79; i += 8) {
        for (int j = 0; j < 8 && (i + j) < 79; j++) {
            if (g_picture_sizes[i + j] > 0) {
                printf("%2d.=%5d byte, ", i + j, g_picture_sizes[i + j]);
                total_bytes += g_picture_sizes[i + j];
            } else {
                printf("%2d.=%5d byte, ", i + j, 0);
            }
        }
        printf("\n");
    }
    printf("summa=%d byte\n\n", total_bytes);
    
    // Print hex sizes in rows of 8
    for (int i = 0; i < 79; i += 8) {
        for (int j = 0; j < 8 && (i + j) < 79; j++) {
            printf("%2d.=%08X, ", i + j, g_picture_sizes[i + j]);
        }
        printf("\n");
    }
    printf("summa=0x%X byte\n", total_bytes);
}

void extract_block(void *data, int block_index) {
    dial_block_t *block = (dial_block_t*)data;
    
    printf("Block %2d.\n", block_index);
    printf("    0x%02X type: %s %s (%s)\n",
           block->blocktype, get_block_type_name(block->blocktype),
           get_block_type_format(block->blocktype), get_block_type_short_name(block->blocktype, block_index));
    printf("    0x%08X    (%7d) picture address\n",
           block->picture_address, block->picture_address);
    printf("    0x%02X,0x%02X     (%3d,%3d) picidx,valami2\n",
           block->picidx, block->valami2, block->picidx, block->valami2);
    printf("    0x%04X,0x%04X (%3d,%3d) sx,sy\n",
           block->sx, block->sy, block->sx, block->sy);
    printf("    0x%04X,0x%04X (%3d,%3d) posX,posY\n",
           block->posX, block->posY, block->posX, block->posY);
    printf("    0x%02X,0x%02X     (%3d,%3d) parts,blocktype\n",
           block->parts, block->blocktype, block->parts, block->blocktype);
    printf("    0x%02X,0x%02X,0x%02X,0x%02X (%3d,%3d,%3d,%3d) align,compr,centX,centY\n",
           block->align, block->compr, block->centX, 0, block->align, block->compr, block->centX, 0);
}

// Decompress image data using various algorithms based on compression type and JieLi format knowledge
unsigned char* decompress_image_data(unsigned char* compressed_data, int compressed_size, int width, int height, unsigned char compr_type, int* output_size) {
    if (!compressed_data || compressed_size <= 0 || width <= 0 || height <= 0) {
        return NULL;
    }
    
    // Determine format based on compression type and data analysis
    int bytes_per_pixel = 4; // Default RGBA
    int expected_size = width * height * bytes_per_pixel;
    
    // Check for PNG signature first
    if (compressed_size > 8 && 
        compressed_data[0] == 0x89 && compressed_data[1] == 0x50 && 
        compressed_data[2] == 0x4E && compressed_data[3] == 0x47) {
        // This is a PNG file, return as-is for external processing
        unsigned char* output = malloc(compressed_size);
        if (!output) return NULL;
        memcpy(output, compressed_data, compressed_size);
        *output_size = compressed_size;
        return output;
    }
    
    // Check for JPEG signature
    if (compressed_size > 2 && 
        compressed_data[0] == 0xFF && compressed_data[1] == 0xD8) {
        // This is a JPEG file, return as-is for external processing
        unsigned char* output = malloc(compressed_size);
        if (!output) return NULL;
        memcpy(output, compressed_data, compressed_size);
        *output_size = compressed_size;
        return output;
    }
      // Analyze compression type and data size to determine format
    // Based on JieLi menu.res format analysis
    if (compr_type == 0) {
        // Type 0: Auto-detect format from data size ratios
        double ratio = (double)compressed_size / (width * height);
        if (ratio <= 1.2) {
            bytes_per_pixel = 1; // Monochrome or compressed monochrome
        } else if (ratio <= 2.2) {
            bytes_per_pixel = 2; // RGB565 or compressed RGB565
        } else if (ratio <= 3.2) {
            bytes_per_pixel = 3; // RGB888 or compressed RGB888
        } else {
            bytes_per_pixel = 4; // RGBA or YUVA
        }
        expected_size = width * height * bytes_per_pixel;
    } else if (compr_type == 1) {
        // Type 1: Palette-based (pal8) - typically uses RLE compression
        bytes_per_pixel = 1; // Palette indices or monochrome
        expected_size = width * height;
    } else if (compr_type == 2) {
        // Type 2: RGB565 format (16-bit)
        bytes_per_pixel = 2;
        expected_size = width * height * 2;
    } else if (compr_type == 3) {
        // Type 3: RGB888 format (24-bit)
        bytes_per_pixel = 3;
        expected_size = width * height * 3;
    } else if (compr_type == 4) {
        // Type 4: YUV420 format (12-bit per pixel average)
        bytes_per_pixel = 1; // Will be handled specially
        expected_size = width * height + (width * height) / 2;
    } else if (compr_type == 5) {
        // Type 5: JPEG format (should have been caught above)
        unsigned char* output = malloc(compressed_size);
        if (!output) return NULL;
        memcpy(output, compressed_data, compressed_size);
        *output_size = compressed_size;
        return output;
    } else {
        // Unknown compression type - try to guess from size
        double ratio = (double)compressed_size / (width * height);
        if (ratio <= 1.2) {
            bytes_per_pixel = 1;
        } else if (ratio <= 2.2) {
            bytes_per_pixel = 2;
        } else if (ratio <= 3.2) {
            bytes_per_pixel = 3;
        } else {
            bytes_per_pixel = 4;
        }
        expected_size = width * height * bytes_per_pixel;
    }
    
    unsigned char* output = malloc(expected_size);
    if (!output) return NULL;
    
    // Check if data is already uncompressed (size matches expected)
    if (compressed_size == expected_size) {
        memcpy(output, compressed_data, compressed_size);
        *output_size = compressed_size;
        return output;
    }
    
    // Apply decompression based on format type
    int input_pos = 0;
    int output_pos = 0;
      if (compr_type == 1 || bytes_per_pixel == 1) {
        // JieLi-style RLE decompression for monochrome/palette images
        // Based on ru2unpack.py lines 194-196: bytes > 0xC0 indicate repeat count
        while (input_pos < compressed_size && output_pos < expected_size) {
            unsigned char byte = compressed_data[input_pos++];
            
            // JieLi RLE: if byte > 0xC0, it's a repeat count for the next byte
            if (byte > 0xC0) {
                int repeat_count = byte - 0xC0;
                
                // Get the next byte to repeat (if available)
                if (input_pos < compressed_size) {
                    unsigned char value_to_repeat = compressed_data[input_pos++];
                    
                    // Write the value 'repeat_count' times
                    for (int i = 0; i < repeat_count && output_pos < expected_size; i++) {
                        output[output_pos++] = value_to_repeat;
                    }
                } else {
                    // No value to repeat, treat as literal
                    output[output_pos++] = byte;
                }
            } else {
                // Literal byte, copy directly
                output[output_pos++] = byte;
            }
        }    } else {
        // For RGB565, RGB888, YUV420: apply format-specific decompression
        if (compr_type == 2) {
            // RGB565 format - check if data needs byte swapping or decompression
            if (compressed_size < expected_size) {
                // Try simple RLE for RGB565
                while (input_pos + 1 < compressed_size && output_pos + 1 < expected_size) {
                    unsigned char byte1 = compressed_data[input_pos++];
                    
                    if (byte1 > 0xC0 && input_pos + 1 < compressed_size) {
                        // RLE pattern: repeat next 2 bytes (RGB565 pixel)
                        int repeat_count = byte1 - 0xC0;
                        unsigned char pixel_low = compressed_data[input_pos++];
                        unsigned char pixel_high = compressed_data[input_pos++];
                        
                        for (int i = 0; i < repeat_count && output_pos + 1 < expected_size; i++) {
                            output[output_pos++] = pixel_low;
                            output[output_pos++] = pixel_high;
                        }
                    } else {
                        // Literal bytes
                        output[output_pos++] = byte1;
                        if (input_pos < compressed_size && output_pos < expected_size) {
                            output[output_pos++] = compressed_data[input_pos++];
                        }
                    }
                }
            } else {
                // Direct copy for uncompressed RGB565
                memcpy(output, compressed_data, expected_size);
                output_pos = expected_size;
            }
        } else if (compr_type == 3) {
            // RGB888 format - similar to RGB565 but with 3-byte pixels
            if (compressed_size < expected_size) {
                while (input_pos < compressed_size && output_pos + 2 < expected_size) {
                    unsigned char byte1 = compressed_data[input_pos++];
                    
                    if (byte1 > 0xC0 && input_pos + 2 < compressed_size) {
                        // RLE pattern: repeat next 3 bytes (RGB888 pixel)
                        int repeat_count = byte1 - 0xC0;
                        unsigned char r = compressed_data[input_pos++];
                        unsigned char g = compressed_data[input_pos++];
                        unsigned char b = compressed_data[input_pos++];
                        
                        for (int i = 0; i < repeat_count && output_pos + 2 < expected_size; i++) {
                            output[output_pos++] = r;
                            output[output_pos++] = g;
                            output[output_pos++] = b;
                        }
                    } else {
                        // Literal bytes
                        output[output_pos++] = byte1;
                        if (input_pos < compressed_size && output_pos < expected_size) {
                            output[output_pos++] = compressed_data[input_pos++];
                        }
                        if (input_pos < compressed_size && output_pos < expected_size) {
                            output[output_pos++] = compressed_data[input_pos++];
                        }
                    }
                }
            } else {
                // Direct copy for uncompressed RGB888
                memcpy(output, compressed_data, expected_size);
                output_pos = expected_size;
            }
        } else {
            // Unknown compression or format 0: try intelligent decompression
            if (compressed_size >= expected_size) {
                // Likely uncompressed, direct copy
                memcpy(output, compressed_data, expected_size);
                output_pos = expected_size;
            } else {
                // Try generic RLE with JieLi pattern
                while (input_pos < compressed_size && output_pos < expected_size) {
                    unsigned char byte = compressed_data[input_pos++];
                    
                    if (byte > 0xC0 && input_pos < compressed_size) {
                        int repeat_count = byte - 0xC0;
                        unsigned char value = compressed_data[input_pos++];
                        
                        for (int i = 0; i < repeat_count && output_pos < expected_size; i++) {
                            output[output_pos++] = value;
                        }
                    } else {
                        output[output_pos++] = byte;
                    }
                }
            }
        }
    }
    
    *output_size = output_pos;
    return output;
}

// Write PNG file using libpng
int write_png_file(const char* filename, unsigned char* image_data, int width, int height) {
    FILE* fp = fopen(filename, "wb");
    if (!fp) return 0;
    
    png_structp png = png_create_write_struct(PNG_LIBPNG_VER_STRING, NULL, NULL, NULL);
    if (!png) {
        fclose(fp);
        return 0;
    }
    
    png_infop info = png_create_info_struct(png);
    if (!info) {
        png_destroy_write_struct(&png, NULL);
        fclose(fp);
        return 0;
    }
    
    if (setjmp(png_jmpbuf(png))) {
        png_destroy_write_struct(&png, &info);
        fclose(fp);
        return 0;
    }
    
    png_init_io(png, fp);
    
    // Set image properties
    png_set_IHDR(png, info, width, height, 8, PNG_COLOR_TYPE_RGBA,
                 PNG_INTERLACE_NONE, PNG_COMPRESSION_TYPE_DEFAULT, PNG_FILTER_TYPE_DEFAULT);
    
    png_write_info(png, info);
    
    // Write image data
    png_bytep* row_pointers = malloc(height * sizeof(png_bytep));
    for (int y = 0; y < height; y++) {
        row_pointers[y] = image_data + y * width * 4;
    }
    
    png_write_image(png, row_pointers);
    png_write_end(png, NULL);
    
    free(row_pointers);
    png_destroy_write_struct(&png, &info);
    fclose(fp);
    
    return 1;
}

void extract_image_data(int block_index, dial_block_t *block, const char *output_dir) {
    char filename[512];
    const char *short_name = get_block_type_short_name(block->blocktype, block_index);
    
    // Generate appropriate filename based on block type
    switch(block->blocktype) {
        case 0x81: // Preview
            snprintf(filename, sizeof(filename), "%s/prev.png", output_dir);
            break;
        case 0x02: // Background
            snprintf(filename, sizeof(filename), "%s/background2.png", output_dir);
            break;
        case 0x82: // Background with index
            snprintf(filename, sizeof(filename), "%s/background%d.png", output_dir, block_index);
            break;
        case 0x89: // Hours digits
        case 0x8A: // Minutes digits  
        case 0x8B: // Battery digits
        case 0x8C: // Month digits
        case 0x87: // Month digits (alternative)
        case 0x8E: // Steps digits
        case 0x98: // Battery strip
            {
                const char *type_prefix = "";
                switch(block->blocktype) {
                    case 0x89: type_prefix = "hours"; break;
                    case 0x8A: type_prefix = "minutes"; break;
                    case 0x8B: 
                    case 0x98: type_prefix = "battery"; break;
                    case 0x8C: 
                    case 0x87: type_prefix = "Month"; break;
                    case 0x8E: type_prefix = "steps"; break;
                }
                
                // Extract individual digit images based on parts count
                for (int i = 0; i < block->parts; i++) {
                    if (i < 10) {
                        snprintf(filename, sizeof(filename), "%s/chr_%s_%d.png", output_dir, type_prefix, i);
                    } else if (i == 10) {
                        snprintf(filename, sizeof(filename), "%s/chr_%s_:.png", output_dir, type_prefix);
                    } else if (i == 11) {
                        snprintf(filename, sizeof(filename), "%s/chr_%s_;.png", output_dir, type_prefix);
                    }
                    
                    // Calculate offset for this digit
                    int digit_size = g_picture_sizes[block->picidx] / block->parts;
                    int offset = i * digit_size;                      // Extract compressed data and try to decompress
                    unsigned char *compressed_data = (unsigned char*)g_main_buffer + block->picture_address + offset;
                    
                    // Try PNG decompression first
                    int digit_width = block->sx;
                    int digit_height = block->sy;
                    
                    // Debug: Print compression info
                    printf("    Digit %d: size=%d, compr=%d, format=%dx%d\n", i, digit_size, block->compr, digit_width, digit_height);
                      int decompressed_size;
                    unsigned char *decompressed_data = decompress_image_data(compressed_data, digit_size, 
                                                                           digit_width, digit_height, block->compr, &decompressed_size);
                    
                    if (decompressed_data && write_png_file(filename, decompressed_data, digit_width, digit_height)) {
                        free(decompressed_data);
                    } else {
                        // Fallback: write raw data with .bin extension
                        char raw_filename[512];
                        snprintf(raw_filename, sizeof(raw_filename), "%s.bin", filename);
                        
                        FILE *fp = fopen(raw_filename, "wb");
                        if (fp) {
                            fwrite(compressed_data, 1, digit_size, fp);
                            fclose(fp);
                        }
                        if (decompressed_data) free(decompressed_data);
                    }
                }
                return; // Don't create single file for multi-part images
            }
            break;
        default:
            // Only create file if short_name is not empty
            if (strlen(short_name) > 0) {
                snprintf(filename, sizeof(filename), "%s/%s.png", output_dir, short_name);
            } else {
                return; // Skip blocks with empty short names
            }
            break;
    }
      // Extract single image
    if (g_picture_sizes[block->picidx] > 0) {
        unsigned char *compressed_data = (unsigned char*)g_main_buffer + block->picture_address;
        
        // Debug: Print compression info
        printf("    Single image: size=%d, compr=%d, format=%dx%d\n", 
               g_picture_sizes[block->picidx], block->compr, block->sx, block->sy);
        
          int decompressed_size;
        unsigned char *decompressed_data = decompress_image_data(compressed_data, g_picture_sizes[block->picidx], 
                                                               block->sx, block->sy, block->compr, &decompressed_size);
        
        if (decompressed_data && write_png_file(filename, decompressed_data, block->sx, block->sy)) {
            free(decompressed_data);
        } else {
            // Fallback: write raw data with .bin extension  
            char raw_filename[512];
            snprintf(raw_filename, sizeof(raw_filename), "%s.bin", filename);
            
            FILE *fp = fopen(raw_filename, "wb");
            if (fp) {
                fwrite(compressed_data, 1, g_picture_sizes[block->picidx], fp);
                fclose(fp);
            }
            if (decompressed_data) free(decompressed_data);
        }
    }
}

void save_output_to_file() {
    char basename[256];
    const char *base = strrchr(g_filename, '/');
    base = base ? base + 1 : g_filename;
    strncpy(basename, base, sizeof(basename) - 1);
    basename[sizeof(basename) - 1] = '\0';
    char *dot = strrchr(basename, '.');
    if (dot) *dot = '\0';
    
    char output_dir[512];
    snprintf(output_dir, sizeof(output_dir), "_%s", basename);
    
    char output_file[512];
    snprintf(output_file, sizeof(output_file), "%s/block_all.txt", output_dir);
    
    FILE *fp = fopen(output_file, "w");
    if (!fp) return;
    
    // Write picture summary to file
    fprintf(fp, "Number of block = %d , (0x%04X)\n", g_block_count, g_block_count);
    
    unsigned short block_table_size = *(unsigned short*)g_main_buffer;
    fprintf(fp, "Size of pltable = %d , (0x%04X)\n\n", block_table_size, block_table_size);
    
    // Print byte sizes in rows of 8
    int total_bytes = 0;
    for (int i = 0; i < 79; i += 8) {
        for (int j = 0; j < 8 && (i + j) < 79; j++) {
            if (g_picture_sizes[i + j] > 0) {
                fprintf(fp, "%2d.=%5d byte, ", i + j, g_picture_sizes[i + j]);
                total_bytes += g_picture_sizes[i + j];
            } else {
                fprintf(fp, "%2d.=%5d byte, ", i + j, 0);
            }
        }
        fprintf(fp, "\n");
    }
    fprintf(fp, "summa=%d byte\n\n", total_bytes);
    
    // Print hex sizes in rows of 8
    for (int i = 0; i < 79; i += 8) {
        for (int j = 0; j < 8 && (i + j) < 79; j++) {
            fprintf(fp, "%2d.=%08X, ", i + j, g_picture_sizes[i + j]);
        }
        fprintf(fp, "\n");
    }
    fprintf(fp, "summa=0x%X byte\n", total_bytes);
    
    // Write block information
    for (int i = 0; i < g_block_count; i++) {
        dial_block_t *block = (dial_block_t*)((char*)g_main_buffer + 4 + (i * 20));
        
        fprintf(fp, "Block %2d.\n", i + 1);
        fprintf(fp, "    0x%02X type: %s %s (%s)\n",
               block->blocktype, get_block_type_name(block->blocktype),
               get_block_type_format(block->blocktype), get_block_type_short_name(block->blocktype, i + 1));
        fprintf(fp, "    0x%08X    (%7d) picture address\n",
               block->picture_address, block->picture_address);
        fprintf(fp, "    0x%02X,0x%02X     (%3d,%3d) picidx,valami2\n",
               block->picidx, block->valami2, block->picidx, block->valami2);
        fprintf(fp, "    0x%04X,0x%04X (%3d,%3d) sx,sy\n",
               block->sx, block->sy, block->sx, block->sy);
        fprintf(fp, "    0x%04X,0x%04X (%3d,%3d) posX,posY\n",
               block->posX, block->posY, block->posX, block->posY);
        fprintf(fp, "    0x%02X,0x%02X     (%3d,%3d) parts,blocktype\n",
               block->parts, block->blocktype, block->parts, block->blocktype);
        fprintf(fp, "    0x%02X,0x%02X,0x%02X,0x%02X (%3d,%3d,%3d,%3d) align,compr,centX,centY\n",
               block->align, block->compr, block->centX, block->centY, block->align, block->compr, block->centX, block->centY);
    }
    
    fclose(fp);
}

void process_dial_data() {
    printf("HK89 dial decompressor v1.8\n");
    
    // Extract just the filename from the full path
    const char *base = strrchr(g_filename, '/');
    base = base ? base + 1 : g_filename;
    printf("----------- %s -----------\n", base);
    
    printf("Number of block = %d , (0x%04X)\n", g_block_count, g_block_count);
    unsigned short block_table_size = *(unsigned short*)g_main_buffer;
    printf("Size of pltable = %d , (0x%04X)\n", block_table_size, block_table_size);
    
    g_text_buffer = malloc(MAX_TEXT_SIZE);
    if (!g_text_buffer) {
        puts("stxt malloc error!");
        return;
    }
    g_text_buffer[0] = '\0';
    
    calculate_picture_sizes();
    
    // Extract images first
    char basename2[256];
    const char *base2 = strrchr(g_filename, '/');
    base2 = base2 ? base2 + 1 : g_filename;
    strncpy(basename2, base2, sizeof(basename2) - 1);
    basename2[sizeof(basename2) - 1] = '\0';
    char *dot2 = strrchr(basename2, '.');
    if (dot2) *dot2 = '\0';
    
    char output_dir[512];
    snprintf(output_dir, sizeof(output_dir), "_%s", basename2);
    
    for (int i = 0; i < g_block_count; i++) {
        dial_block_t *block = (dial_block_t*)((char*)g_main_buffer + 4 + (i * 20));
        extract_image_data(i + 1, block, output_dir);
    }
    
    for (int i = 0; i < g_block_count; i++) {
        extract_block((char*)g_main_buffer + 4 + (i * 20), i + 1);
    }
    
    save_output_to_file();
    free(g_text_buffer);
}

int main(int argc, char *argv[]) {
    if (argc <= 1) {
        puts("No .bin filename specified!");
        return 0;
    }
    
    g_filename = argv[1];
    
    g_main_buffer = malloc(MAX_MEMORY_SIZE);
    if (!g_main_buffer) {
        printf("Memory allocation failed!\n");
        return 0;
    }
    
    FILE *fp = fopen(g_filename, "rb");
    if (!fp) {
        printf("No such file! (%s)\n", g_filename);
        free(g_main_buffer);
        return 0;
    }
    
    g_file_size = get_file_size(fp);
    if (g_file_size > MAX_MEMORY_SIZE) {
        printf("File too large\n");
        fclose(fp);
        free(g_main_buffer);
        return 0;
    }
    
    fread(g_main_buffer, 1, g_file_size, fp);
    fclose(fp);
    
    create_output_directory(g_filename);
    g_block_count = ((unsigned char*)g_main_buffer)[2];
    process_dial_data();
    
    if (g_picture_sizes) {
        free(g_picture_sizes);
    }
    free(g_main_buffer);
    return 0;
}
