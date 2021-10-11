(defn fi
  ([max seq]
   (let [[a b] (reverse seq)
         next (+ a b)]
     (if (> next max)
       seq
       (fi max (into seq [next])))))
  ([max] (fi max [0 1 1])))

; sum of even fibo numbers until 4.000.000
(def res (reduce + (filter #(= 0(rem % 2)) (fi 4000000))))

(println res)
