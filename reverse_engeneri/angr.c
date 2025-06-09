extern struct_0 *g_404ff8;

void sub_401000()
{
    if (g_404ff8)
        g_404ff8();
    return;
}

extern unsigned long long g_405008;
extern unsigned long long g_405010;

void sub_401020()
{
    unsigned long long v0;  // [bp-0x8]

    v0 = g_405008;
    goto g_405010;
}

typedef struct struct_0 {
    char padding_0[8];
    unsigned long long field_8;
} struct_0;

typedef struct FILE_t {
    unsigned int _flags;
    char padding_4[4];
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_marker *_chain;
    unsigned int _fileno;
    unsigned int _flags2;
    unsigned int _old_offset;
    char padding_7c[4];
    unsigned short _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    char padding_84[4];
    struct _IO_marker *_lock;
    unsigned long long _offset;
    struct _IO_codecvt *_codecvt;
    struct _IO_wide_data *_wide_data;
    void* _freeres_list;
    char __pad5;
    char padding_b1[7];
    unsigned int _mode;
    char _unused2[20];
} FILE_t;

typedef struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_marker *_sbuf;
    unsigned int _pos;
} _IO_marker;

typedef struct _IO_codecvt {
    char __cd_out;
} _IO_codecvt;

typedef struct _IO_wide_data {
    unsigned short *_IO_read_ptr;
    unsigned short *_IO_read_end;
    unsigned short *_IO_read_base;
    unsigned short *_IO_write_base;
    unsigned short *_IO_write_ptr;
    unsigned short *_IO_write_end;
    unsigned short *_IO_buf_base;
    unsigned short *_IO_buf_end;
    unsigned short *_IO_save_base;
    unsigned short *_IO_backup_base;
    unsigned short *_IO_save_end;
    __mbstate_t _IO_state;
    char padding_5d[3];
    char _IO_last_state;
    char padding_61[7];
    unsigned short _shortbuf[1];
    _IO_marker _wide_vtable;
} _IO_wide_data;

typedef struct __mbstate_t {
    unsigned int __count;
    char __value;
} __mbstate_t;

extern struct_1 *g_405120;
extern unsigned long long g_538c20;
extern unsigned int g_538c30;
extern char g_538d5a;

int main(unsigned int a0, struct_0 *a1)
{
    char *v1;  // rdi
    FILE_t *v2;  // rbp
    unsigned int v3;  // eax

    printf("HK89 dial decompressor %s\n", "v1.8");
    g_405120 = malloc(0x12c000);
    if (!g_405120)
    {
        printf("Unable to reserve %d byte memory!\n", a1);
        return 0;
    }
    g_538c30 = 0x12c000;
    if (a0 <= 1)
    {
        puts("No .bin filename specified!");
        free(g_405120);
        return 0;
    }
    v1 = a1->field_8;
    g_538c20 = a1->field_8;
    v2 = fopen(v1, "rb");
    if (!v2)
    {
        printf("No such file! (%s)\n", g_538c20);
        return 0;
    }
    v3 = sub_4014e0(v2);
    if (g_538c30 < v3)
    {
        printf("File too large (>%d Byte)\n", g_538c30);
        free(g_405120);
        return 0;
    }
    fread(g_405120, v3, 1, v2);
    fclose(v2);
    sub_401520(g_538c20);
    g_538d5a = g_405120->field_2;
    sub_402cc0(v3);
    free(g_405120);
    return 1;
}

void _start(unsigned long a0, unsigned long a1, unsigned long long a2)
{
    unsigned long long v0;  // [bp+0x0]
    unsigned long v1;  // [bp+0x8]
    unsigned long long v2;  // rax

    v0 = v2;
    __libc_start_main(main, v0, &(char)v1, init, fini, a2, &v0, v0); /* do not return */
}

void sub_40134e()
{
    [D] Unsupported jumpkind Ijk_SigTRAP at address 4199246()
}

void sub_401350()
{
    return;
}

void sub_401360()
{
    return;
}

long long sub_401381()
{
    return 0;
}

extern char g_405100;

void sub_4013d0()
{
    char *v0;  // [bp-0x8]
    struct struct_0 v1[8];  // [bp+0x0]

    if (!g_405100)
    {
        v0 = &v1[0].field_0;
        sub_401360();
        g_405100 = 1;
    }
    return;
}

void sub_401400()
{
}

typedef struct struct_0 {
    char padding_0[8];
    unsigned short field_8;
    unsigned short field_a;
    unsigned int field_c;
    unsigned int field_10;
} struct_0;

extern unsigned int g_405104;
extern unsigned int g_538c1c;
extern unsigned int g_538c2c;
extern unsigned int g_538c34;
extern unsigned int g_538c3c;

long long sub_401410(struct_0 *a0)
{
    unsigned long long v1;  // rax

    if (!g_405104)
    {
        g_405104 = 1;
        g_538c3c = a0->field_c;
        g_538c34 = a0->field_10;
        g_538c1c = a0->field_8;
        g_538c2c = a0->field_a;
    }
    return v1;
}

void sub_401450()
{
    return;
}

typedef struct struct_0 {
    char padding_0[8];
    unsigned short field_8;
    unsigned short field_a;
    unsigned int field_c;
    unsigned int field_10;
} struct_0;

extern unsigned int g_405108;
extern unsigned int g_538c28;
extern unsigned int g_538c38;
extern unsigned int g_538c48;
extern unsigned int g_538c4c;

long long sub_401460(struct_0 *a0)
{
    unsigned long long v1;  // rax

    if (!g_405108)
    {
        g_405108 = 1;
        g_538c28 = a0->field_c;
        g_538c4c = a0->field_10;
        g_538c48 = a0->field_8;
        g_538c38 = a0->field_a;
    }
    return v1;
}

extern char g_403010;

int sub_4014a0(char a0[4], char *a1)
{
    return sprintf(a1, &g_403010, a0[1] & 127, a0[3] * 10 & 4294967295);
}

void sub_4014d0()
{
    return;
}

typedef struct FILE_t {
    unsigned int _flags;
    char padding_4[4];
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_marker *_chain;
    unsigned int _fileno;
    unsigned int _flags2;
    unsigned int _old_offset;
    char padding_7c[4];
    unsigned short _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    char padding_84[4];
    struct _IO_marker *_lock;
    unsigned long long _offset;
    struct _IO_codecvt *_codecvt;
    struct _IO_wide_data *_wide_data;
    void* _freeres_list;
    char __pad5;
    char padding_b1[7];
    unsigned int _mode;
    char _unused2[20];
} FILE_t;

typedef struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_marker *_sbuf;
    unsigned int _pos;
} _IO_marker;

typedef struct _IO_codecvt {
    char __cd_out;
} _IO_codecvt;

typedef struct _IO_wide_data {
    unsigned short *_IO_read_ptr;
    unsigned short *_IO_read_end;
    unsigned short *_IO_read_base;
    unsigned short *_IO_write_base;
    unsigned short *_IO_write_ptr;
    unsigned short *_IO_write_end;
    unsigned short *_IO_buf_base;
    unsigned short *_IO_buf_end;
    unsigned short *_IO_save_base;
    unsigned short *_IO_backup_base;
    unsigned short *_IO_save_end;
    __mbstate_t _IO_state;
    char padding_5d[3];
    char _IO_last_state;
    char padding_61[7];
    unsigned short _shortbuf[1];
    _IO_marker _wide_vtable;
} _IO_wide_data;

typedef struct __mbstate_t {
    unsigned int __count;
    char __value;
} __mbstate_t;

long long sub_4014e0(FILE_t *a0)
{
    unsigned int v1;  // eax

    fseek(a0, 0, 2);
    v1 = ftell(a0);
    fseek(a0, 0, 0);
    return v1;
}

extern char g_538b20;

void sub_401520(char *a0)
{
    char v0[256];  // [bp-0x108]

    strncpy(&v0, "_", 246);
    strncat(&v0, a0, 246);
    *(strrchr(&v0, 46)) = 0;
    strcpy(&g_538b20, &v0);
    mkdir(&v0, 511);
    return;
}

int sub_401580()
{
    char v1;  // [bp+0x18]

    if (*((int *)*((long long *)&v1)) > 0)
        *((int *)*((long long *)&v1)) = *((int *)*((long long *)&v1)) - 1;
    return;
}

void sub_4015a0(char a0[2], char *a1, char *a2, char *a3)
{
    unsigned long v1;  // rax
    unsigned int v2;  // edx

    v1 = a0[1] | (unsigned int)(a0[0] * 0x100);
    v2 = v1;
    *(a1) = (unsigned int)(v1 >> 8) & 0xfffffff8;
    *(a2) = v2 >> 3 & 0xfffffffc;
    *(a3) = v2 * 8 & 4294967295;
    return;
}

void sub_4015d0(unsigned long a0, unsigned long a1, unsigned long a2, unsigned long a3, unsigned int a4)
{
    unsigned long long v0;  // [bp-0x38]
    unsigned long long v1;  // [bp-0x30]
    unsigned long v2;  // [bp-0x28]
    unsigned long long v3;  // [bp-0x20]
    unsigned long long v4;  // [bp-0x18]
    unsigned long long v5;  // [bp-0x10]
    unsigned long long v6;  // [bp-0x8]
    unsigned long long v9;  // r15
    unsigned long long v10;  // rax
    unsigned long long v11;  // r14
    unsigned long long v12;  // r13
    unsigned long long v13;  // rsi
    unsigned long long v14;  // r12
    unsigned int v15;  // edi
    unsigned long long v16;  // r8
    unsigned long long v17;  // rbx
    unsigned long long v18;  // r11
    void* v19;  // rdx
    void* v20;  // rcx
    void* v21;  // rcx
    unsigned int v22;  // eax
    unsigned int v23;  // eax
    unsigned long v24;  // rax
    unsigned int v25;  // r9d

    if (a4 <= 0)
        return;
    v6 = v9;
    v10 = a3 - 1 & 4294967295;
    v5 = v11;
    v4 = v12;
    v13 = 0;
    v3 = v14;
    v15 = 0;
    *((int *)&v2) = vvar_63{reg 56};
    v16 = 0;
    v1 = v17;
    v0 = a1 + v10 * 4 + 4;
    do
    {
        if ((unsigned int)a3 > 0)
        {
            v18 = v16 & 4294967295;
            v19 = a1 + v18;
            v20 = (v13 & 4294967295) + a0;
            do
            {
                v19 += 4;
                v21 = v20 + 3;
                v22 = (char)v20[1] * 0x100;
                v23 = (char)v21[1];
                *((char *)&v19[1]) = *((char *)v20);
                v24 = v23 | v22;
                v25 = v24;
                *((char *)&v19[4]) = (unsigned int)(v24 >> 8) & 0xfffffff8;
                *((char *)&v19[2]) = v25 * 8 & 4294967295;
                *((char *)&v19[3]) = v25 >> 3 & 0xfffffffc;
                v20 = v21;
            } while (v18 + v0 != v19);
            v16 = v16 + ((v10 & 4294967295) * 4 & 4294967295) + 4 & 4294967295;
            v13 = v13 + (a3 * 3 & 4294967295) & 4294967295;
        }
    } while ((v13 = (((char)v13 & 3) ? (unsigned long long)(((unsigned int)v13 & 0xfffffffc) + 4) : v13 & 4294967295), v15 += 1, a4 != v15));
    return;
}

long long sub_4016b0(void* a0, char *a1, unsigned int *a2, unsigned int a3, unsigned int a4, unsigned int a5, unsigned int a6)
{
    unsigned int v0;  // [bp-0x58]
    unsigned int v1;  // [bp-0x54]
    char v2[2];  // [bp-0x50]
    unsigned int v3;  // [bp-0x48]
    unsigned long long v4;  // [bp-0x30]
    unsigned long long v5;  // [bp-0x20]
    unsigned long long v6;  // [bp-0x18]
    unsigned long long v7;  // [bp-0x10]
    unsigned long long v8;  // [bp-0x8]
    unsigned long long v9;  // r15
    unsigned long long v10;  // r14
    unsigned long long v11;  // r13
    unsigned long long v12;  // r12
    unsigned long long v13;  // rbx
    unsigned int v14;  // ebx
    unsigned long long v15;  // r15
    unsigned int v16;  // r10d
    unsigned int v17;  // esi
    unsigned long long v18;  // rdi
    char v19[2];  // rcx
    unsigned int v20;  // edx
    unsigned long v21;  // rdi
    unsigned int v22;  // ecx
    unsigned int v23;  // esi
    unsigned int v24;  // esi
    unsigned long v25;  // rdx
    unsigned int v26;  // r8d
    unsigned int v27;  // r8d
    unsigned long v28;  // rdx
    unsigned long v29;  // r9
    unsigned int v30;  // ebx
    unsigned int v31;  // eax
    char v32[2];  // r8
    unsigned int v33;  // r12d
    unsigned long v34;  // rax
    unsigned int v35;  // edx
    unsigned int v36;  // ecx
    unsigned int v37;  // ebx
    unsigned int v38;  // ebx
    unsigned int v39;  // ebx
    unsigned int v40;  // ebx
    unsigned long long v41;  // r12

    v8 = v9;
    v7 = v10;
    v6 = v11;
    v5 = v12;
    v4 = v13;
    v14 = 0;
    v33 = *((short *)a0);
    v0 = 0;
    if (a4 > 0)
    {
        do
        {
            v16 = 0;
            if (a3 > 0)
            {
                do
                {
                    v17 = v33 + 1;
                    v18 = *((char *)a0 + v33);
                    v19 = v17 + a0;
                    if ((char)v18)
                    {
                        v20 = v19[0];
                        if ((char)v18 >= 0)
                        {
LABEL_401732:
                            v33 = v17;
                            v22 = v14;
                            v23 = 0;
                            while (true)
                            {
                                if (!a5)
                                {
                                    v31 = v20;
                                    v32 = v33 + a0;
                                }
                                else
                                {
                                    v33 += 1;
                                    v15 = v20;
                                    v32 = v33 + a0;
                                    v31 = v32[0];
                                }
                                v33 += 2;
                                v34 = (unsigned int)(v31 * 0x100) | v32[1];
                                v35 = v34;
                                a1[v14] = (unsigned int)(v34 >> 8) & 0xfffffff8;
                                v14 += 3;
                                a1[1 + v14] = v35 >> 3 & 0xfffffffc;
                                a1[2 + v22] = v35 * 8 & 4294967295;
                                if (a5)
                                {
                                    a1[v14] = v15;
                                    v14 = v22 + 4;
                                }
                                v23 += 1;
                                if (v23 == (unsigned int)v18)
                                    break;
                                v22 = v14;
                                v20 = *((char *)a0 + v33);
                            }
                            v16 = v16 + v23 & 4294967295;
                            if (a6)
                            {
                                v1 = v16;
                                printf("unique: cnt=%d j=%d i=%d\n", v23, v0, v1);
                                v16 = v1;
                            }
                        }
                        else
                        {
                            v21 = (unsigned int)v18 & 127;
                            if (a5)
                            {
                                v17 = v33 + 2;
                                v15 = v20;
                                v19 = v17 + a0;
                                v20 = v19[0];
                            }
                            v33 = v17 + 2;
                            v24 = v21;
                            v25 = (unsigned int)(v20 * 0x100) | v19[1];
                            v26 = v25;
                            v27 = v26 * 8;
                            v28 = (unsigned int)(v25 >> 8) & 0xfffffff8;
                            v29 = v26 >> 3 & 0xfffffffc;
                            v30 = v14;
                            if ((char)v21)
                            {
                                v36 = 0;
                                v37 = v14;
                                while (true)
                                {
                                    v38 = v37;
                                    a1[v38] = v28;
                                    a1[1 + v38] = v29;
                                    a1[2 + v38] = v27;
                                    if (a5)
                                    {
                                        v36 += 1;
                                        v39 = v38 + 4;
                                        a1[v40] = v15;
                                        v37 = v39;
                                        v30 = v39;
                                        if (v36 == v24)
                                            break;
                                    }
                                    else
                                    {
                                        v36 += 1;
                                        v40 = v38 + 3;
                                        v37 = v40;
                                        v30 = v40;
                                        if (v36 == v24)
                                            break;
                                    }
                                }
                            }
                            v14 = v30;
                            v16 = v16 + v24 & 4294967295;
                            if (a6)
                            {
                                v1 = v16;
                                printf("ism   : cnt=%d r=%d g=%d b=%d a=%d j=%d i=%d\n", v24, v28 & 4294967295, v29 & 4294967295, v27 & 248, v15 & 4294967295, v0, v1);
                                v16 = v1;
                            }
                        }
                    }
                    else if (!a6)
                    {
                        v20 = v19[0];
                        v18 = 1;
                        goto LABEL_401732;
                    }
                    else
                    {
                        v3 = v16;
                        *(&v2) = v19;
                        v1 = v17;
                        puts("cnt=0 , exiting...");
                        v17 = v1;
                        v18 = 1;
                        v16 = v3;
                        v20 = v2[0];
                        goto LABEL_401732;
                    }
                } while (a3 > v16);
            }
        } while ((v0 += 1, a4 != v0));
    }
    *(a2) = v14;
    v41 = v33 - -1 - ((v33 & 1) < 1);
    return (((char)v41 & 3) ? (unsigned int)(v41 + 2) : (unsigned int)v41);
}

typedef struct FILE_t {
    unsigned int _flags;
    char padding_4[4];
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_marker *_chain;
    unsigned int _fileno;
    unsigned int _flags2;
    unsigned int _old_offset;
    char padding_7c[4];
    unsigned short _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    char padding_84[4];
    struct _IO_marker *_lock;
    unsigned long long _offset;
    struct _IO_codecvt *_codecvt;
    struct _IO_wide_data *_wide_data;
    void* _freeres_list;
    char __pad5;
    char padding_b1[7];
    unsigned int _mode;
    char _unused2[20];
} FILE_t;

typedef struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_marker *_sbuf;
    unsigned int _pos;
} _IO_marker;

typedef struct _IO_codecvt {
    char __cd_out;
} _IO_codecvt;

typedef struct _IO_wide_data {
    unsigned short *_IO_read_ptr;
    unsigned short *_IO_read_end;
    unsigned short *_IO_read_base;
    unsigned short *_IO_write_base;
    unsigned short *_IO_write_ptr;
    unsigned short *_IO_write_end;
    unsigned short *_IO_buf_base;
    unsigned short *_IO_buf_end;
    unsigned short *_IO_save_base;
    unsigned short *_IO_backup_base;
    unsigned short *_IO_save_end;
    __mbstate_t _IO_state;
    char padding_5d[3];
    char _IO_last_state;
    char padding_61[7];
    unsigned short _shortbuf[1];
    _IO_marker _wide_vtable;
} _IO_wide_data;

typedef struct __mbstate_t {
    unsigned int __count;
    char __value;
} __mbstate_t;

void sub_401980(void* a0, unsigned int a1, char *a2)
{
    FILE_t *v1;  // rax

    v1 = fopen(a2, "wb");
    fwrite(a0, a1, 1, v1);
    fclose(v1);
    return;
}

long long sub_4019c0(char *a0, unsigned int a1, unsigned int a2, unsigned int a3, unsigned int a4)
{
    unsigned int v0;  // [bp-0x20e4]
    unsigned int v1;  // [bp-0x20dc]
    unsigned long v2;  // [bp-0x20d8]
    unsigned int v3;  // [bp-0x20cc]
    unsigned long long v4;  // [bp-0x20c8]
    void* v5;  // [bp-0x20c0]
    unsigned long long v6;  // [bp-0x20b8]
    unsigned int v7;  // [bp-0x20b0]
    unsigned int v8;  // [bp-0x20ac]
    void* v9;  // [bp-0x20a8]
    unsigned int v10;  // [bp-0x20a0]
    unsigned int v11;  // [bp-0x209c]
    unsigned int v12;  // [bp-0x2098]
    char v13;  // [bp-0x2091]
    unsigned int v14;  // [bp-0x2088]
    unsigned int v15;  // [bp-0x2080]
    unsigned int v16;  // [bp-0x207c]
    char v17;  // [bp-0x2078]
    char v18;  // [bp-0x2038]
    unsigned int v20;  // r14d
    unsigned int v21;  // ebx
    char v22;  // bl
    char v23;  // r8b
    void* v24;  // rbx
    unsigned int v25;  // r15d
    unsigned int v26;  // r13d
    unsigned long long v27;  // rdx
    unsigned int v28;  // eax
    unsigned int v29;  // r8d
    unsigned int v30;  // r12d
    void* v31;  // rdi
    unsigned int v32;  // eax
    unsigned int v33;  // eax
    unsigned long v34;  // rax
    void* v36;  // rdx
    unsigned int v37;  // eax
    unsigned int v38;  // eax
    char v39;  // al
    char v40;  // bl

    v5 = malloc(0x13a600);
    *((char *)v5) = 0;
    if (a4 <= 0)
        return v5;
    v20 = a3;
    v1 = a2 * 4;
    v14 = 0;
    v21 = 0;
    v10 = 0;
    *((int *)&v2) = (a3 ? "RGBA" : "RGB");
    v8 = 0;
    v3 = 0;
    v0 = a2 - 1;
    while (true)
    {
        if ((v22 & 3))
            v21 += 2;
        v30 = v1 + v21;
        strcat(v5, &v18);
        printf(&v18);
        if (a2 > 0)
        {
            v9 = 0;
            v6 = v0;
            v4 = &a0[v21];
            while (true)
            {
                v18 = 0;
                v12 = 0;
                v7 = (int)v9;
                if (a1 > 0)
                {
                    v24 = 0;
                    v25 = 0;
                    v11 = 0;
                    v16 = 0;
                    v26 = v20;
                    while (true)
                    {
                        v30 += 1;
                        v27 = a0[v30];
                        v28 = v27;
                        if (!((char)v28 & 127))
                        {
                            v20 = v26;
                            v30 = v30;
                            sprintf(&v17, "counter 0 error at line:%d pix:%d %s, ", v7, v25, v2);
                            strcat(&v18, &v17);
                            break;
                        }
                        if ((char)v27 < 0)
                        {
                            v14 += 1;
                            v15 = v28 & 127;
                            v24 = (unsigned int)v24 + 1;
                            sprintf(&v17, "#%02X, ", v27);
                            strcat(&v18, &v17);
                            v29 = v15;
                            v16 += v29;
                            if (v26)
                                v30 += 2;
                            v25 += v29;
                            v30 += 2;
                            if (v25 < a1)
                                continue;
LABEL_401c4d:
                            v30 = v30;
                            v20 = v26;
                            break;
                        }
                        else
                        {
                            v12 += (unsigned int)v27;
                            v10 += (unsigned int)v27;
                            v13 = v27;
                            v15 = v27;
                            v11 += 1;
                            v8 += 1;
                            sprintf(&v17, "#%02X, ", v27);
                            strcat(&v18, &v17);
                            v25 += v15;
                            do
                            {
                                v30 = v30 - -1 - (v26 < 1) + 2;
                                v23 -= 1;
                            } while (v23 != 1);
                            v16 = v16;
                            if (!(v25 < a1))
                                goto LABEL_401c4d;
                        }
                    }
                }
                else
                {
                    v16 = 0;
                    v24 = 0;
                    v25 = 0;
                    v11 = 0;
                }
                sprintf(&v17, "= %d pixel\n", v25);
                strcat(&v18, &v17);
                sprintf(&v17, "%02hhX,%02hhX - (%02hhX,%02hhX) - (%03X,%03X) {%04X}{%04X}{%04X} ", *((char *)(v4 + v9 * 4 + 3)), *((char *)(v4 + v9 * 4 + 2)), v8, v10, v14, v11, v24, v12, v16);
                v5 = v5;
                do
                {
                    v31 = v5 + 4;
                    v32 = *((int *)v5) - 16843009 & ~(*((int *)v5));
                    v33 = v32 & 2155905152;
                    v5 = v31;
                } while (!(v32 & 2155905152));
                v34 = (!(v33 & 32896) ? v33 >> 16 : v33);
                if (!((unsigned short)v33 & 32896))
                    v31 += 2;
                strcpy(stpcpy(v31 - 3 - (((char)((v34 & 4294967295) + v34) <= (char)(v34 & 4294967295) ? 1 : 0) & 1), &v17), &v18);
                if (v6 == v9)
                    break;
                v9 += 1;
            }
        }
        v5 = v5;
        do
        {
            v36 = v5 + 4;
            v37 = *((int *)v5) - 16843009 & ~(*((int *)v5));
            v38 = v37 & 2155905152;
            v5 = v36;
        } while (!(v37 & 2155905152));
        v39 = (!(v38 & 32896) ? v38 >> 16 : v38);
        if (!((unsigned short)v38 & 32896))
            v36 += 2;
        v40 = v39;
        v22 = v40 + v39;
        v3 += 1;
        *((unsigned short *)(-3 + (char *)v36 - ((v40 + v39 <= v40 ? 1 : 0) & 1))) = 10;
        if (a4 == v3)
            break;
        v21 = v30 - -1 - ((v30 & 1) < 1);
    }
    return v3;
}

typedef struct FILE_t {
    unsigned int _flags;
    char padding_4[4];
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_marker *_chain;
    unsigned int _fileno;
    unsigned int _flags2;
    unsigned int _old_offset;
    char padding_7c[4];
    unsigned short _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    char padding_84[4];
    struct _IO_marker *_lock;
    unsigned long long _offset;
    struct _IO_codecvt *_codecvt;
    struct _IO_wide_data *_wide_data;
    void* _freeres_list;
    char __pad5;
    char padding_b1[7];
    unsigned int _mode;
    char _unused2[20];
} FILE_t;

typedef struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_marker *_sbuf;
    unsigned int _pos;
} _IO_marker;

typedef struct _IO_codecvt {
    char __cd_out;
} _IO_codecvt;

typedef struct _IO_wide_data {
    unsigned short *_IO_read_ptr;
    unsigned short *_IO_read_end;
    unsigned short *_IO_read_base;
    unsigned short *_IO_write_base;
    unsigned short *_IO_write_ptr;
    unsigned short *_IO_write_end;
    unsigned short *_IO_buf_base;
    unsigned short *_IO_buf_end;
    unsigned short *_IO_save_base;
    unsigned short *_IO_backup_base;
    unsigned short *_IO_save_end;
    __mbstate_t _IO_state;
    char padding_5d[3];
    char _IO_last_state;
    char padding_61[7];
    unsigned short _shortbuf[1];
    _IO_marker _wide_vtable;
} _IO_wide_data;

typedef struct __mbstate_t {
    unsigned int __count;
    char __value;
} __mbstate_t;

void sub_401e40(char *a0, unsigned int a1, unsigned int a2, unsigned int a3, char *a4)
{
    void* v0;  // [bp-0x58], Other Possible Types: unsigned long long
    FILE_t *v1;  // [bp-0x50]
    unsigned long long v2;  // [bp-0x48], Other Possible Types: unsigned int
    unsigned long long v4;  // r15
    void* v5;  // rax
    void* v6;  // rdx
    void* v7;  // r13
    unsigned long long v8;  // r14
    unsigned long long v9;  // r12
    void* v10;  // rbx
    unsigned long long v11;  // r11
    void* v12;  // rcx
    char *v13;  // rax
    unsigned int v14;  // edi
    unsigned int v15;  // edx
    unsigned long long v16;  // r8
    void* v17;  // r13

    v1 = &fopen(a0, "wb")->_flags;
    v4 = png_create_write_struct("1.6.36", 0, 0, 0);
    v0 = png_create_info_struct(v4);
    png_init_io(v4, v1);
    v2 = v0;
    png_set_IHDR(v4, v0, a1, a2, 8, (-(a3 < 1) & 0xfffffffc) + 6, 0, 0, 0);
    v5 = malloc(a2 * 8);
    v0 = v5;
    if (a2 > 0)
    {
        v6 = v5;
        v7 = v5;
        v2 = -(a3 < 1) + 4;
        v8 = v6 + (a2 - 1) * 8 + 8;
        v9 = v2;
        v10 = v6;
        do
        {
            v10 += 8;
            *((void* *)&v10[8]) = malloc(png_get_rowbytes(v4, v9));
        } while (v10 != v8);
        v11 = v2;
        v15 = 0;
        v12 = v0;
        do
        {
            v13 = 0;
            v14 = 0;
            if (a1 > 0)
            {
                while (true)
                {
                    v13[*((long long *)v12)] = a4[v15];
                    v13[1 + *((long long *)v12)] = a4[1 + v15];
                    v16 = v15 + 3;
                    v13[2 + *((long long *)v12)] = a4[2 + v15];
                    if ((unsigned int)v11 != 4)
                    {
                        v14 += 1;
                        v15 = v16;
                        v13 = &v13[v11];
                        if (a1 == v14)
                            break;
                    }
                    else
                    {
                        v14 += 1;
                        v15 += 4;
                        v13[3 + *((long long *)v12)] = a4[v16 & 4294967295];
                        v13 = &v13[v11];
                        if (a1 == v14)
                            break;
                    }
                }
            }
        } while ((v12 += 8, v12 != v8));
        png_write_info(v4, v9);
        png_write_image(v4, v0);
        png_write_end(v4, 0);
        do
        {
            v17 = v7 + 8;
            free(*((long long *)v7));
            v7 = v17;
        } while (v17 != v8);
    }
    else
    {
        png_write_info(v4, v9);
        png_write_image(v4, v0);
        png_write_end(v4, 0);
    }
    free(v0);
    fclose(v1);
    return;
}

extern unsigned long long g_405120;
extern char *g_538c40;
extern char g_538d5a;

void sub_402070(unsigned int a0, unsigned int a1)
{
    char v0[1032];  // [bp-0x438]
    void* v2;  // r14
    unsigned int v3;  // r12d
    unsigned long long v4;  // r14
    unsigned long long v5;  // rcx
    unsigned long long v6;  // r8
    unsigned long v7;  // rdx
    unsigned long long v8;  // rax
    unsigned long long v9;  // rdx

    if (a1 > 0)
    {
        v2 = 0;
        v3 = 0;
        while (true)
        {
            v4 = v2;
            v5 = v4 & 4294967295;
            v6 = *((int *)(((g_538d5a * 5 & 4294967295) * 4 & 4294967295) + v4 * 4 + g_405120 + 4));
            v7 = (!((unsigned int)v4 & 7) ? "\n" : ", ");
            if (a0)
                sprintf(&v0, "%s%2d.=%08X", v7, v5, v6);
            else
                sprintf(&v0, "%s%2d.=%5d byte", v7, v5, v6);
            v3 += *((int *)(((g_538d5a * 5 & 4294967295) * 4 & 4294967295) + v4 * 4 + g_405120 + 4));
            strncat(g_538c40, &v0, 0x8000);
            v8 = v4 + 1;
            if (a1 - 1 == v4)
                break;
            v2 = v8;
        }
    }
    else
    {
        v3 = 0;
    }
    v9 = v3;
    if (a0)
        sprintf(&v0, "\nsumma=0x%X byte\n", v9);
    else
        sprintf(&v0, "\nsumma=%d byte\n", v9);
    strncat(g_538c40, &v0, 0x8000);
    return;
}

extern struct_0 *g_405120;

long long sub_4021a0(unsigned int a0)
{
    if (g_405120->field_0 <= a0)
    {
        puts("Too big index!");
        return 0;
    }
    return *((int *)&(&g_405120[1].padding_1)[((g_405120->field_2 * 5 & 4294967295) * 4 & 4294967295) + (a0 * 4 & 4294967295)]);
}

typedef struct struct_0 {
    unsigned int field_0;
    char field_4;
    char padding_5[1];
    unsigned short field_6;
    unsigned short field_8;
    char padding_a[4];
    char field_e;
    char field_f;
} struct_0;

extern unsigned long long g_405120;
extern char g_405140;
extern char g_538b20;
extern char g_538c60;

void sub_4021f0(struct_0 *a0, char *a1)
{
    unsigned int v0;  // [bp-0xcc]
    unsigned int v1[1];  // [bp-0xbc]
    char v2[136];  // [bp-0xb8]
    unsigned long long v4;  // r14
    unsigned int v5;  // r13d
    unsigned int v6;  // ebx
    void* v7;  // r12
    unsigned int v8;  // ecx

    strncpy(&v2, a1, 20);
    v4 = a0->field_6;
    v5 = a0->field_8;
    if ((v4 & 65535) * 0x1000000000000 <= 0x400000000000000 && v5 <= 1600)
    {
        if (a0->field_e)
        {
            v6 = 0;
            v7 = a0->field_0 + g_405120;
            do
            {
                sub_4021a0(a0->field_4 + v6);
                *((unsigned short *)&stpcpy(&g_538c60, &g_538b20)) = 47;
                sprintf(&v2, "chr_%s_%c.png", a1, v6 + 48);
                strcat(&g_538c60, &v2);
                if (a0->field_f >= 0)
                {
                    v8 = 0;
                    v0 = sub_4016b0(v7, &g_405140, &v1, v4, v5, 0, 0);
                }
                else
                {
                    v8 = 1;
                    v0 = sub_4016b0(v7, &g_405140, &v1, v4, v5, 1, 0);
                }
                v6 += 1;
                sub_401e40(&g_538c60, v4, v5, v8, &g_405140);
                v7 += v0;
            } while (a0->field_e > v6);
            return;
        }
        else
        {
            return;
        }
    }
    printf("Wrong image size! (%dx%d)\n", v4 & 4294967295, v5);
    return;
}

typedef struct struct_1 {
    unsigned int field_0;
    char field_4;
    char padding_5[1];
    unsigned short field_6;
    unsigned short field_8;
    char padding_a[5];
    char field_f;
    char padding_10[1];
    char field_11;
} struct_1;

typedef struct struct_0 {
    unsigned int field_0;
    char field_4;
} struct_0;

extern unsigned long long g_405120;
extern char g_405140;
extern char g_538b20;
extern char g_538c60;

void sub_402370(struct_1 *a0, char *a1, unsigned long a2, unsigned int a3)
{
    char v0;  // [bp-0x2c], Other Possible Types: unsigned int
    unsigned long long v2;  // r14
    unsigned int v3;  // r13d
    unsigned long v4;  // r12
    char *v5;  // rax
    struct_0 *v6;  // rax
    char *v7;  // rax
    struct_0 *v8;  // rax

    v2 = a0->field_6;
    v3 = a0->field_8;
    v4 = a0->field_0 + g_405120;
    if ((v2 & 65535) * 0x1000000000000 <= 0x400000000000000 && v3 <= 1600)
    {
        if (a3)
        {
            v5 = stpcpy(&g_538c60, &g_538b20);
            *(v5) = 47;
            v6 = stpcpy(v5 + 1, a1);
            v6->field_0 = 1852400174;
            v6->field_4 = 0;
            v0 = sub_4021a0(a0->field_4);
            sub_401980(v4, v0, &g_538c60);
        }
        v7 = stpcpy(&g_538c60, &g_538b20);
        *(v7) = 47;
        v8 = stpcpy(v7 + 1, a1);
        v8->field_0 = 1735290926;
        v8->field_4 = 0;
        if (a0->field_f >= 0)
        {
            sub_4016b0(v4, &g_405140, &v0, v2, v3, 0, 0);
            sub_401e40(&g_538c60, v2, v3, 0, &g_405140);
            return;
        }
        if (a0->field_11 != 6)
            sub_4015d0(v4, &g_405140, &v0, v2 & 4294967295, v3);
        else
            sub_4016b0(v4, &g_405140, &v0, v2, v3, 1, 0);
        sub_401e40(&g_538c60, v2, v3, 1, &g_405140);
        return;
    }
    printf("Wrong image size! (%dx%d)\n", v2 & 4294967295, v3);
    return;
}

typedef struct struct_0 {
    char field_0;
    char padding_1[3];
    char field_4;
    char field_5;
    unsigned short field_6;
    unsigned short field_8;
    unsigned short field_a;
    unsigned short field_c;
    char field_e;
    char field_f;
    char field_10;
    char field_11;
    char field_12;
    char field_13;
} struct_0;

extern char *g_538c40;

void sub_402520(struct_0 *a0, unsigned int a1, unsigned int a2, unsigned int a3)
{
    char v0[8];  // [bp-0x4b8], Other Possible Types: unsigned long long
    char v1[4];  // [bp-0x4b4]
    char v2;  // [bp-0x4b0], Other Possible Types: unsigned int, unsigned short
    char v3;  // [bp-0x4ae]
    char v4;  // [bp-0x4ac]
    char v5[1032];  // [bp-0x438]
    unsigned int v7;  // r14d
    unsigned long long v8;  // rdx
    unsigned long long v9;  // rcx
    char *v10;  // r15
    unsigned long long v11;  // rcx
    unsigned long long v12;  // r8
    unsigned long long v13;  // rdx

    v7 = a0->padding_1[0];
    printf("Block %2d.\n", a1);
    sprintf(&v5, "Block %2d.\n", a1);
    strncat(g_538c40, &v5, 0x8000);
    v8 = a0->field_f;
    *(v0) = 0;
    *(&v0) = v0 & 0xffffff00 | (unsigned int)v0;
    switch ((unsigned int)v8 & 127 & 255)
    {
    case 1:
        v10 = &v0;
        *(v1) = 0;
        strncpy(v0, "prev", 4);
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "Preview image";
        break;
    case 2:
        v10 = &v0;
        sprintf(&v0, "background%d", a1);
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "Background image";
        break;
    case 3:
        v10 = &v0;
        v2 = 0;
        v0 = 8247620786667221601;
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "Arm hour";
        break;
    case 4:
        v10 = &v0;
        v2 = 25972;
        v3 = 0;
        v0 = 8461816668349100641;
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "Arm minute";
        break;
    case 5:
        v10 = &v0;
        v2 = 25710;
        v3 = 0;
        v0 = 8026370507101008481;
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "Arm second";
        break;
    case 6:
        v9 = "Year";
        v10 = &v0;
        break;
    case 7:
        v10 = &v0;
        strncpy(v1, "Month", 5);
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Month";
        break;
    case 8:
        v9 = "Day";
        v10 = &v0;
        break;
    case 9:
        v10 = &v0;
        strncpy(v1, "hours", 5);
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Hours";
        break;
    case 10:
        v10 = &v0;
        v0 = 32481173182507373;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Minutes";
        break;
    case 11:
        v10 = &v0;
        v0 = 32480047799690611;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Seconds";
        break;
    case 12:
        v9 = "AM/PM";
        v10 = &v0;
        break;
    case 13:
        v9 = "Day of week";
        v10 = &v0;
        break;
    case 14:
        v10 = &v0;
        strncpy(v1, "steps", 5);
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Steps";
        break;
    case 15:
        v9 = "Pulse";
        v10 = &v0;
        break;
    case 16:
        v9 = "Calory";
        v10 = &v0;
        break;
    case 17:
        v9 = "Distance";
        v10 = &v0;
        break;
    case 18:
        v9 = "Battery";
        v10 = &v0;
        break;
    case 19: case 20: case 21: case 25: case 26: case 27: case 28: case 29: case 30: case 31:
        v9 = "Unknown ???";
        v10 = &v0;
        break;
    case 22:
        v10 = &v0;
        strncpy(v0, "bigy", 4);
        *((unsigned short *)&v1[0]) = 111;
        sub_402370(a0, &v0, v7, 0);
        v8 = a0->field_f;
        v9 = "axle pawl";
        break;
    case 23:
        v2 = 1735290926;
        v9 = "Animation";
        v10 = &v0;
        v0 = 8390876191244512865;
        v4 = 0;
        break;
    case 24:
        v10 = &v0;
        v0 = 34184252253036898;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "Battery strip";
        break;
    case 39:
        v10 = &v0;
        v0 = 29634176751071080;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "HoursHi";
        break;
    case 40:
        v10 = &v0;
        v0 = 31327424657846120;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "HoursLo";
        break;
    case 41:
        v10 = &v0;
        v2 = 105;
        v0 = 5197265520846334317;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "MinuteHi";
        break;
    case 42:
        v10 = &v0;
        v2 = 111;
        v0 = 5485495896998046061;
        sub_4021f0(a0, &v0);
        v8 = a0->field_f;
        v9 = "MinuteLo";
        break;
    default:
        v9 = "Unknown ?????";
        v10 = &v0;
        break;
    }
    sprintf(&v5, "    0x%02X type: %s %4s (%s)\n", v8, v9, (!((v8 & 255) >> 7 & 1) ? "RGB" : "RGBA"), v10);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    sprintf(&v5, "    0x%08X    (%7u) picture address\n", *((int *)&a0->field_0), *((int *)&a0->field_0));
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    sprintf(&v5, "    0x%02X,0x%02X     (%3u,%3u) picidx,valami2\n", a0->field_4, a0->field_5, a0->field_4, a0->field_5);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    sprintf(&v5, "    0x%04X,0x%04X (%3u,%3u) sx,sy\n", a0->field_6, a0->field_8, a0->field_6, a0->field_8);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    sprintf(&v5, "    0x%04X,0x%04X (%3u,%3u) posX,posY\n", a0->field_a, a0->field_c, a0->field_a, a0->field_c);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    sprintf(&v5, "    0x%02X,0x%02X     (%3u,%3u) parts,blocktype\n", a0->field_e, a0->field_f, a0->field_e, a0->field_f);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    v11 = a0->field_11;
    v12 = a0->field_12;
    v13 = a0->field_10;
    sprintf(&v5, "    0x%02X,0x%02X,0x%02X,0x%02X (%3u,%3u,%3u,%3u) align,compr,centX,centY\n", v13, v11, v12, a0->field_13, v13, v11, v12, a0->field_13);
    printf("%s", &v5);
    strncat(g_538c40, &v5, 0x8000);
    return;
}

typedef struct struct_1 {
    char field_0;
    char padding_1[8];
    unsigned int field_9;
    unsigned short field_d;
} struct_1;

typedef struct FILE_t {
    unsigned int _flags;
    char padding_4[4];
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_marker *_chain;
    unsigned int _fileno;
    unsigned int _flags2;
    unsigned int _old_offset;
    char padding_7c[4];
    unsigned short _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    char padding_84[4];
    struct _IO_marker *_lock;
    unsigned long long _offset;
    struct _IO_codecvt *_codecvt;
    struct _IO_wide_data *_wide_data;
    void* _freeres_list;
    char __pad5;
    char padding_b1[7];
    unsigned int _mode;
    char _unused2[20];
} FILE_t;

typedef struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_marker *_sbuf;
    unsigned int _pos;
} _IO_marker;

typedef struct _IO_codecvt {
    char __cd_out;
} _IO_codecvt;

typedef struct _IO_wide_data {
    unsigned short *_IO_read_ptr;
    unsigned short *_IO_read_end;
    unsigned short *_IO_read_base;
    unsigned short *_IO_write_base;
    unsigned short *_IO_write_ptr;
    unsigned short *_IO_write_end;
    unsigned short *_IO_buf_base;
    unsigned short *_IO_buf_end;
    unsigned short *_IO_save_base;
    unsigned short *_IO_backup_base;
    unsigned short *_IO_save_end;
    __mbstate_t _IO_state;
    char padding_5d[3];
    char _IO_last_state;
    char padding_61[7];
    unsigned short _shortbuf[1];
    _IO_marker _wide_vtable;
} _IO_wide_data;

typedef struct __mbstate_t {
    unsigned int __count;
    char __value;
} __mbstate_t;

extern struct_0 *g_405120;
extern char g_538b20;
extern unsigned long long g_538c20;
extern struct_2 *g_538c40;
extern char g_538c60;
extern char g_538d5a;

void sub_402cc0(unsigned int a0)
{
    char v0;  // [bp-0x458]
    char v1;  // [bp-0x44c]
    char v2[1024];  // [bp-0x418]
    unsigned int v4;  // ebp
    unsigned int v5;  // ecx
    unsigned long long v6;  // rbp
    unsigned int v7;  // ebx
    unsigned long long v8;  // rbp
    struct_1 *v9;  // rax
    FILE_t *v10;  // rbp
    unsigned long v11;  // rax

    v4 = g_405120->field_0;
    printf("----------- %s -----------\n", g_538c20);
    g_538c40 = malloc(0x8000);
    if (!g_538c40)
    {
        puts("stxt malloc error!");
        return;
    }
    g_538c40->field_0 = 0;
    sprintf(&v2, "Number of block = %d , (0x%04X)\n", g_538d5a, g_538d5a);
    printf("%s", &v2);
    strncat(g_538c40, &v2, 0x8000);
    sprintf(&v2, "Size of pltable = %d , (0x%04X)\n", v4, v4);
    printf("%s", &v2);
    strncat(g_538c40, &v2, 0x8000);
    sub_402070(0, v4);
    sub_402070(1, v4);
    v5 = g_538d5a;
    if (g_538d5a)
    {
        v6 = 4;
        v7 = 0;
        do
        {
            v7 += 1;
            v8 = v6 + 20;
            sub_402520((char *)g_405120 + v6, v7, a0, v5);
            v5 = g_538d5a;
            v6 = v8;
        } while (v7 < g_538d5a);
    }
    v9 = stpcpy(&g_538c60, &g_538b20);
    strncpy(&v0, "block_al", 8);
    strncpy(&v1, "l.txt", 5);
    *((unsigned short *)&v9->field_0) = 47;
    *((unsigned long long *)&v9->padding_1[0]) = 7809628143671536738;
    *((unsigned short *)((char *)&v9->field_9 + 1)) = 116;
    *((unsigned int *)&(&v9->padding_1)[1]) = 2020879980;
    v10 = fopen(&g_538c60, "wb");
    v11 = strlen(g_538c40);
    fwrite(g_538c40, v11, 1, v10);
    fclose(v10);
    free(g_538c40);
    return;
}

long long sub_402e90(unsigned int a0)
{
    unsigned long long v0;  // [bp-0x8]
    unsigned int v2;  // edx
    unsigned long long v3;  // rbx

    v2 = (a0 + (a0 >> 31 >> 30) & 3) - (a0 >> 31 >> 30);
    if (v2 > 0)
    {
        v0 = v3;
        printf("align %d to %d\n", a0, a0 - v2 + 4);
        return a0 - v2 + 4;
    }
    return a0;
}

extern struct_1 g_404df0;

void init(unsigned int a0, unsigned long long a1, unsigned long long a2)
{
    void* v1;  // rbx

    sub_401000();
    v1 = 0;
    do
    {
        *((long long *)((char *)&g_404df0.field_0 + 0x8 * v1))(a0, a1, a2);
        v1 += 1;
    } while (v1 != 1);
    return;
}

void fini()
{
    return;
}

void sub_402f48()
{
    return;
}

