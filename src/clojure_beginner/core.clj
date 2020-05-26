(ns clojure-beginner.core
  (:use ring.middleware.params
        ring.util.response
        ring.adapter.jetty
        clojure-beginner.mainfunc))


(defn page [ax ay bx by cx cy px py]
  (str "<html><body>"
       (if ax
         (str "The dot is " (check ax ay, bx by, cx cy, px py) "!")
         (str "Enter vertices of a triangle and a point:"
           "<form>"
              "A(x): <input name='ax' type='number'>
              (y): <input name='ay' type='number'><br>"
              "B(x): <input name='bx' type='number'>
              (y): <input name='by' type='number'><br>"
              "C(x): <input name='cx' type='number'>
              (y): <input name='cy' type='number'><br>"
              "Point (x): <input name='px' type='number'>\n
              (y): <input name='py' type='number'><br>"
              "<input type='submit'>"
              "</form>"))
       "</body></html>"))

(defn handler [{{ax "ax" ay "ay" bx "bx" by "by" cx "cx" cy "cy" px "px" py "py"} :params}]
  (-> (response (page ax ay bx by cx cy px py))
      (content-type "text/html")))

(def app
  (-> handler wrap-params))

(defn -main []
  (run-jetty app {:port 3003})
  ;(println (is-in 4 -1 6 4 12 3 7 2))
  )
