;https://pt.wikipedia.org/wiki/Crivo_de_Erat%C3%B3stenes

(defn primes-until
  [until]
  (let [max (Math/floor (Math/sqrt until))]
    (loop [primes (range 2 (inc until))
           i 0]
      (let [next-prime (nth primes i)]
        (if (> next-prime max)
          primes
          (recur (filter #(or
                           (= next-prime %)
                           (not= 0 (rem % next-prime))) primes) (inc i)))))))

(defn is-factor [y] #(= 0 (rem y %)))

;(def n 600 851 475 143)
(def n 75143)

(defn euler3
  [x]
  (filter (is-factor x) (primes-until x)))

(println (str "-> " (last (euler3 n))))
