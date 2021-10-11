; fibonacci using function overloading
(defn fi
  ([max seq]
   (let [[a b] (reverse seq)
         next (+ a b)]
     (if (> next max)
       seq
       (fi max (into seq [next])))))
  ([max] (fi max [0 1 1])))

; fibonacci using loop/recur
(defn fib
  [max]
  (loop [seq [0 1 1]]
    (let [[a b] (reverse seq)
          next (+ a b)]
      (if (> next max)
        seq
        (recur (into seq [next]))))))

(println (str "(fi 1000): " (fi 1000)))
(println (str "(fib 1000): " (fib 1000)))
