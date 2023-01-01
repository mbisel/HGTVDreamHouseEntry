(ns views.styles
  "Instead of loading a .css file, use css-in-cljs to load these straight into the page."
  (:require [garden.core :as garden :refer [css]]))

(defn stylesheet
  "Our stylesheet"
  []
  (css))



(defn mount-style
  "Mount the style-element into the header with `style-text`, ensuring this is the only `<style>` in the doc"
  [style-text]
  (let [head (or (.-head js/document)
                 (aget (.getElementsByTagName js/document "head") 0))
        style-el (doto (.createElement js/document "style")
                   (-> .-type (set! "text/css"))
                   (.appendChild (.createTextNode js/document style-text)))]
    (.appendChild head style-el)))
