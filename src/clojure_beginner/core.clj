(ns clojure-beginner.core
  (:use ring.middleware.params
        ring.util.response
        ring.adapter.jetty
        clojure-beginner.mainfunc))




(defn page [a]
  (str "<html><body>"
       (if a
         (str "Nice to meet you, " a "!")
         (str "<form>"
              "A(x): <input a='ax' type='number'>
              (y): <input name='ay' type='number'><br>"
              "B(x): <input a='bx' type='number'>
              (y): <input name='by' type='number'><br>"
              "C(x): <input a='cx' type='number'>
              (y): <input name='cy' type='number'><br>"
              "Point (x): <input a='px' type='number'>\n
              (y): <input name='py' type='number'><br>"
              "<input type='submit'>"
              "</form>"))
       "</body></html>"))

(defn handler [{{name "name"} :params}]
  (-> (response (page name))
      (content-type "text/html")))

(def app
  (-> handler wrap-params))

(defn -main []
  (run-jetty app {:port 3000})
  (println (is-in 7 2 4 -1 6 4 12 3)))
