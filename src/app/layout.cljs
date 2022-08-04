(ns app.layout
  (:require [app.components.header :refer [header]]
            [app.routes :as routes]))


(defn app []
  [:div
   [header]
   (let [current-view (-> @routes/routes-state :data :view)] [current-view])])