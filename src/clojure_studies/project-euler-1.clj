(defn multiples
  [max]
  (loop [num (- max 1)
         sum 0]
    (if (< num 0)
      sum
      (recur
       (- num 1)
       (if (or (= 0 (rem num 3)) (= 0 (rem num 5)))
         (+ sum num)
         sum)))))

(multiples 1000)
