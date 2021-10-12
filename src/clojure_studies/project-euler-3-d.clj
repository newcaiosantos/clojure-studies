;TKS https://pt.wikipedia.org/wiki/Crivo_de_Erat%C3%B3stenes
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

;TKS https://en.wikipedia.org/wiki/Primality_test
(defn is-prime
  [x]
  (print (str "prime test of " x ": "))
  (let [prime (= 0 (count (filter #(= 0 (rem x %)) (primes-until (Math/floor (Math/sqrt x))))))]
    (println prime)
    prime))

;TKS me :D
(defn euler3
  [x]
  (loop [d 2]
    (if (>= d x)
      (println "sorry, no more factors")
      (if (= 0 (rem x d)) ;is factor
        (let [factor (/ x d)]
          (println (str "factor found: " factor))
          (if (is-prime factor)
            factor
            (recur (inc d))))
        (recur (inc d))))))

(def n 600851475143)

(println (str "-> " (euler3 n)))
