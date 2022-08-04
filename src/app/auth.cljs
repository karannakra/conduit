(ns app.auth
  (:require [reagent.core :as r]
            [app.api :refer [api-uri]]
            [ajax.core :refer [POST json-request-format json-response-format]]))


(defonce auth-state (r/atom nil))

;; Register Sucess Handler ==
(defn auth-success! [{{:keys [token] :as user} :user}]
  (.setItem js/localStorage "auth-user-token" token)
  (reset! auth-state user))


;; Api Error handler == 
(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str status status-text)))


;; Api for registration of new user
(defn register! [registration-input]
  (POST (str api-uri "/users")
    {:params {:user registration-input}
     :handler auth-success!
     :format (json-request-format)
     :response-format (json-response-format {:keywords? true})
     :error-handler error-handler}))


;; Api for registration of new user
(defn login! [input]
  (POST (str api-uri "/users/login")
    {:params {:user input}
     :handler auth-success!
     :format (json-request-format)
     :response-format (json-response-format {:keywords? true})
     :error-handler error-handler}))

(comment (register! {:username "learnussidev4@foo.com"
                     :email "learnuissdev4@foo.com"
                     :password "learnssuidev4@foo.com"}))

(comment (login! { :email "learnuissdev4@foo.com"
                  :password "learnssuidev4@foo.com"}))



