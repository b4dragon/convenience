(ns renderer.launcher.core
  (:require [goog.events :as events]
            [reagent.core :as r]
            [re-frame.core :as rf :refer [dispatch-sync]]
            [clojure.string :as string :refer [split-lines]]
            [secretary.core :as secretary :refer [defroute]]
            [devtools.core :as devtools])
  
  (:import [goog History]
           [goog.History EventType]))


(devtools/install!)
(enable-console-print!)

(defn root []
  [:div
   [:h1 "init testing"]])

(defn mount []
  (r/render
   [#'root]
   (js/document.getElementById "root")))


(defn ^:dev/after-load start
  []
  )

(defn ^:dev/before-load stop
  []
  )

(defn ^:export main
  []
  (mount))
