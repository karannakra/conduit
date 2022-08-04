(ns app.components.banner)



;; Banner ==
(defn banner [app-name token]
  (when token
    [:div.banner>div.container
     [:h1.logo-font app-name]
     [:p "A place to share your knowledge."]]))