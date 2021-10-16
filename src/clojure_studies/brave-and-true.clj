; using str function
(println (str "Mamamia " "!"))

; using vector function
(println (apply str (vector "Vem se envolver, " "que no VBBBBB!")))

; using list
(println (list 1 2 3))

; using hash-map
(println (hash-map :name "Caio" :age 32))

; using hash-set
(println (hash-set 1 2 2 3 3 3 4 4 4 4))

; inc
(println (inc 100))

; dec-maker
(defn dec-maker
  [dec-by]
  #(- % dec-by))

(println ((dec-maker 2) 100))

; map-set
(defn map-set
  [f seq]
  (into #{} (map f seq)))

(println (map-set inc [1 1 2 2]))
(println (map inc [1 1 2 2]))

; implement map using reduce
(defn rmap
  [f l]
  (seq (reduce (fn [a v] (into a [(f v)])) (empty l) l)))

(println (str "rmap -> " (rmap inc '(1 2 3))))

; implement filter using reduce
(defn rfilter
  [f l]
  (reduce (fn [a v]
            (if (f v)
              (into a [v])
              a)) (empty l) l))
(println (str "rfilter -> " (rfilter #(> % 1) [1 2 3])))

; implement 'some' using reduce
(defn rsome
  [f s]
  (reduce
   (fn [a v] (or a (f v)))
   false
   s))

(println (str "rsome -> " (rsome #(> % 4 ) [1 2 3])))

; testing 'some'
(println (str "Some test: " (some #(> % 1) [1 2 3])))
(println (str "Some test: " (some #(> % 3) [1 2 3])))
(println (str "Some test: " (some #(= % false) [false 2 3])))
