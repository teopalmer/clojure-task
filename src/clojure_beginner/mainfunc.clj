(ns clojure-beginner.mainfunc)

(defn abs [x]
  (if (> x 0) x (* -1 x)))

(defn func [xa x0 yb ya xb y0]
  (- (* (- xa x0) (- yb ya)) (* (- xb xa) (- ya y0)))
  )

(defn is-in [px py, ax ay, bx by, cx cy]
  (let [f1 (func ax px by ay bx py)
        f2 (func bx px cy by cx py)
        f3 (func cx px ay cy ax py)
        cond (= (= (abs f1) f1) (= (abs f2) f2) (= (abs f3) f3))
        ]
    cond
    ))

(defn check [ax ay, bx by, cx cy, px py]
  (let [result (is-in (Integer/parseInt px) (Integer/parseInt py) (Integer/parseInt ax)
                      (Integer/parseInt ay) (Integer/parseInt bx) (Integer/parseInt by)
                      (Integer/parseInt cx) (Integer/parseInt cy))]
  (if result
    "inside the triangle"
    "out of the triangle")
  )
  )