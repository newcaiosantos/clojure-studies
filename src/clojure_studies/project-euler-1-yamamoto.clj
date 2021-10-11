(defn pega-multiplos
  [x]
  (or (= 0 (rem x 3)) (= 0 (rem x 5))))

(reduce + (filter pega-multiplos (range 1000)))
