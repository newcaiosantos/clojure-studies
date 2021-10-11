(defn pega-multiplos
  [x]
  (or (= 0 (rem x 3)) (= 0 (rem x 5))))

(reduce + (filter pega-multiplos (range 1000)))

; single line version => (reduce + (filter #(or (= 0 (rem % 3)) (= 0 (rem % 5))) (range 1000)))
