(ns app.components.main-view
  (:require [app.components.articles :refer [articles]]
            [app.articles :refer [article-state]]))



;; Main View ==
(defn main-view []
  [:div.col-md-9
   [:div.feed-toggle
    [:ul.nav.nav-pills.outline-active
     [:li.nav-item
      [:a.nav-link.active {:href ""} "Global Feed"]]]]
   [articles (:articles (deref article-state))]])

