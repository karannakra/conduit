(ns app.routes
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            ;; pages
            [app.pages.home :refer [home-page]]
            [app.pages.login :refer [login-page]]
            [app.pages.register :refer [signup-page]]
            [app.pages.settings :refer [settings-page]]))


(defonce routes-state (r/atom  nil))


;; Routes ==
(def routes [["/"  {:name :home
                    :view #'home-page}]
             ["/login" {:name :login
                        :view #'login-page}]
             ["/register" {:name :register
                           :view #'signup-page}]
             ["/settings" {:name :settings
                           :view #'settings-page}]])

;; Router Configuration ==
(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [matched-route] (reset! routes-state matched-route))
   {:use-fragment false}))
