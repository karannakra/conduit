(ns app.pages.login
  (:require [reitit.frontend.easy :as rfe]
            [app.auth :as auth]))



(defn login! [event input]
  (.preventDefault event)
  (auth/login! input))

(defn login-page []
  [:div.auth-page
   [:div.container.page
    [:div.row
     [:div.col-md-6.offset-md-3.col-xs-12
      [:h1.text-xs-center "Sign In"]
      [:p.text-xs-center [:a {:href (rfe/href ::register)} "Need an account?"]]
      [:form {:on-submit #(login! % {})}
       [:fieldset
        [:fieldset.form-group
         [:input.form-control.form-control-lg {:type :email :placeholder "Email"}]]
        [:fieldset.form-group
         [:input.form-control.form-control-lg {:type :password :placeholder "Password"}]]
        [:button.btn.btn.btn-primary.pull-xs-right  {:type :submit} "Sign In"]]]]]]])
