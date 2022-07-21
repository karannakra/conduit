(ns app.components.articles)


;; Article preview UI ==
(defn article-preview [{:keys [title description favoritesCount author createdAt tagList]}]
  [:div.article-preview
   [:div.article-meta
    [:a
     [:img {:src (:image author)}]]
    [:div-info
     [:a.author]
     [:span.date (.toDateString (new js/Date createdAt))]]
    [:div.pull-xs-right
     [:button.btn.btn-sm.btn-outline-primary
      [:i.ion-heart favoritesCount]]]
    [:a.preview-link
     [:h1 title]
     [:p description]
     [:p description]
     [:span "Read More..."]
     [:ul.tag-list
      (for [tag tagList]
        ^{:key tag} [:li.tag-default.tag-pill.tag-outline tag])]]]])



;; Articles ==
(defn articles [items]
  (if-not (seq items)
    [:div.article-preview "Loading..."]
    (if (= 0 (count items))
      [:div.article-preview "No articles are here... yet."]
      [:div
       (for [{:keys [slug] :as article} items]
         ^{:key slug}
         [article-preview article])])))

