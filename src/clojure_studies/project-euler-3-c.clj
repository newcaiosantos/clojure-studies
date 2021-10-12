;(def n 600 851 475 143)
(def n 51475143)

(defn biggest-factor-of
  [x, next-d] ; use 2 as first
  (loop [d next-d]
    (if (>= d x)
      nil
      (if (= 0 (rem x d))
        (/ x d)
        (recur (inc d))))))

(defn factors-of
  [x]
  (loop [d 2
         f []]
    (if (>= d x)
      f
      (recur (inc d) (if (= 0 (rem x d)) (into f [(/ x d)]) f)))))

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

(defn is-prime
  [x]
  (= 0 (count (filter #(= 0 (rem x %)) (primes-until (Math/floor (Math/sqrt x)))))))

(defn euler3 []
  (loop [d 2]
    (let [big-fac (biggest-factor-of n d)]
      (if (> d n)
        nil
        (if (is-prime big-fac)
          big-fac
          (recur (inc d)))))))

(println (euler3))
