(defn is-palindrome
  [s]
  (= (str s) (apply str (reverse (str s)))))

(let [products (map
                 #(map (fn [x] (* x %)) (range 100 1000))
                 (range 100 1000))
      pal-prod (map #(filter is-palindrome %) products)
      all-pal (set (flatten pal-prod))]
  (apply max all-pal))
