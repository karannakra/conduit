(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [app.articles :refer [articles-browse]]
            [app.routes :as routes]
            [reagent.core :as r]
            [app.layout :refer [app]]))

;; States

(defn ^:dev/after-load render
  "Render the toplevel component for this app.
   Dev Mode - runs every time the required dependencies changes"
  []
  (r/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic. Runs only once"
  []
  (routes/router-start!)
  (articles-browse)
  (render))
