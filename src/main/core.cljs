(ns main.core
  (:require ["electron" :refer [app BrowserWindow crashReport]]))

(def main-window (atom nil))

(defn init-browser []
  (reset! main-window (BrowserWindow.
                       (clj->js {:width 800
                                 :height 600
                                 :webPreferences {:nodeIntegration true}})))
  (.loadURL @main-window (str "file://" js/__dirname "/index.html"))
  (.. @main-window -webContents (openDevTools))
  (.on @main-window "closed" #(reset! main-window nil)))

(defn main []
  (.on app "ready" init-browser)
  (.on app "activate" #(when-not @main-window
                         (init-browser)))
  (.on app "window-all-closed" #(when-not (= js/process.platform "darwin")
                                  (.quit app))))

                                             
       
