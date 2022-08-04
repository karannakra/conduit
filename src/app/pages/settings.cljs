(ns app.pages.settings)



;; Settings Form ==


(defn settings-form []
  [:form
   [:fieldset
    [:fieldset.form-group
     [:input.form-control
      {:type :text :placeholder "URL of profile picture"}]]
    [:fieldset.form-group
     [:input.form-control.form-control-lg
      {:type :text :placeholder "UserName"}]]
    [:fieldset.form-group
     [:textarea.form-control.form-control-lg
      {:type :rows 8 :text :placeholder "Short bio about you"}]]
    [:fieldset.form-group
     [:input.form-control.form-control-lg
      {:type :email :placeholder "Email"}]]
    [:fieldset.form-group
     [:input.form-control.form-control-lg
      {:type :password :placeholder "Password"}]]
    [:fieldset.btn.btn-lg.btn-primary.pull-xs-right {:type :submit} "Update Settings"]]])





;; Settings ==
(defn settings-page []
  [:div.settings-page>div.container.page>div.row
   [:div.col-md-6.offset-md-3.col-xs-12
    [:h1.text-xs-center "Your Settings"]
    [settings-form]
    [:hr]
    [:button.btn.btn-outline-danger "Or click here to logout."]]])