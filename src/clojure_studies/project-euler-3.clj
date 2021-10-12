(defn is-divider [x y] (= 0 (rem y x)))

(defn is-prime
  [x]
  (loop [i x
         d 0]
    (if (< i 1)
      (= d 2)
      (if (> d 2)
        false
        (recur (- i 1) (+ d (if (is-divider i x) 1 0)))))))

;(def n 600 851 475 143)
(def n 851475143)

(defn euler3
  []
  (loop [i n]
    (if (< i 1)
      nil
      (if (and (is-divider i n) (is-prime i))
        i
        (recur (- i 1))))))

(println (str "res: " (euler3)))
