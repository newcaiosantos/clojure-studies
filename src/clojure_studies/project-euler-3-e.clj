(defn prime-factors
  [x]
  (loop [factors []
         d 2
         n x]
    (if (<= n 1)
      factors
      (let [[fa nu] (loop [f factors
                           n n]
                      (if (not= 0 (rem n d))
                        [f n]
                        (recur (into f [(/ n d)]) (/ n d))))]
        (recur (into factors fa) (inc d) nu)))))

;(reduce max (prime-factors 600 851 475 143))
(reduce max (prime-factors 20))
