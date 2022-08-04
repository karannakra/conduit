(ns app.articles
  (:require [reagent.core :as r]
            [app.api :refer [api-uri]]
            [ajax.core :refer [GET json-response-format]]))

(defonce article-state (r/atom nil))

;; Api Response Handler ==
(defn handler [response]
  (reset! article-state response))

;; Api Error handler ==
(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str status status-text)))

;; Fetch Article Data ==
(defn articles-browse []
  (GET (str api-uri "/articles?limit=20")
    {:handler handler
     :response-format (json-response-format {:keywords? true})
     :error-handler error-handler}))


(comment (articles-browse)
         (first (:articles (deref article-state))))


