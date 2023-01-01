(ns core
  (:require [reagent.core :as r]
            [views.styles :as style]
            [views.main :as main]))

(defn mount-components []
  (r/render-component [#'main/main] (.getElementById js/document "content")))

(defn init! []
  (style/mount-style (style/stylesheet))
  (mount-components))
