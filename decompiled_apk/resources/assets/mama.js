'use strict';

;(function (window) {
  if (window.MamaBridge) {
    return;
  }
  window.MamaBridge = {
    callHandler: callHandler,
    handleMessageFromNative: handleMessageFromNative,
    addListener: addListener,
    removeListener: removeListener,
    registerHandler: registerHandler
  };
  var messageHandlers = {};
  var successCallbackMap = {};
  var failureCallbackMap = {};
  var eventListeners = {};
  var uniqueId = 1;
  function registerHandler(handlerName, handler) {
    messageHandlers[handlerName] = handler;
  }
  function callHandler(handlerName, data, successCallback, failureCallback) {
    doSend({ handlerName: handlerName, data: data }, successCallback, failureCallback);
  }
  function addListener(eventName, callback) {
    var listeners = eventListeners[eventName];
    if (!listeners) {
      listeners = [];
    }
    listeners.push(callback);
    eventListeners[eventName] = listeners;
  }
  function removeListener(eventName, callback) {
    var listeners = eventListeners[eventName];
    if (!listeners) return;
    var index = listeners.indexOf(callback);
    if (index < 0) return;
    listeners.splice(index, 1);
    eventListeners[eventName] = listeners;
  }
  function doSend(message, successCallback, failureCallback) {
    var callbackId = 'cb_' + uniqueId++ + '_' + new Date().getTime();
    if (successCallback) {
      successCallbackMap[callbackId] = successCallback;
      message.callbackId = callbackId;
    }
    if (failureCallback) {
      failureCallbackMap[callbackId] = failureCallback;
      message.callbackId = callbackId;
    }
    if (window.normal && window.normal.postMessage) {
      window.normal.postMessage(JSON.stringify(message));
    } else {
      window.webkit.messageHandlers.normal.postMessage(JSON.stringify(message));
    }
  }
  function handleMessageFromNative(messageJSON) {
    var message = JSON.parse(messageJSON);
    var responseCallback = void 0;
    if (message.responseId) {
      if (message.success) {
        var successCallback = successCallbackMap[message.responseId];
        if (!successCallback) return;
        successCallback(message.responseData);
      } else {
        var failureCallback = failureCallbackMap[message.responseId];
        if (!failureCallback) return;
        failureCallback(message.responseData);
      }
      delete successCallbackMap[message.responseId];
      delete failureCallbackMap[message.responseId];
      return;
    }
    if (message.eventName) {
      var listenersForEvent = eventListeners[message.eventName];
      if (!listenersForEvent) return;
      listenersForEvent.forEach(function (listener) {
        if (listener) {
          listener(message.eventData);
        }
      });
      return;
    }
    if (message.callbackId) {
      (function () {
        var callbackResponseId = message.callbackId;
        responseCallback = function responseCallback(responseData) {
          doSend({ handlerName: message.handlerName, responseId: callbackResponseId, responseData: responseData });
        };
        var handler = messageHandlers[message.handlerName];
        if (!handler) {
          console.log('MamaBridge: WARNING: no handler for message from ObjC:', message);
        } else {
          handler(message.data, responseCallback);
        }
      })();
    }
  }
 typeof window.onMamaBridgeReady==="function" && window.onMamaBridgeReady()



})(window);