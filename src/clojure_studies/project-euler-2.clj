(loop [[prev-a prev-b] [1 2]
       sum 2]
  (let [next (+ prev-a prev-b)]
    (println next)
    (if (>= next 4000000)
      (println (str "sum is " sum))
      (recur
       [prev-b next]
       (+ sum (if (= 0(rem next 2)) next 0))))))
