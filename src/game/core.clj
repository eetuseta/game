(ns game.core)


(defn get-input []
  (println "Choose your weapon! (r)ock, (p)aper, (s)cissors, (l)izard, sp(o)ck.")
  (let [guess (keyword (read-line))]
    (if (get {:r true :p true :s true :l true :o true} guess) guess)))

(defn win [guess1 guess2]
  (let [guesses [guess1 guess2]]
        (cond
          (= guess1 guess2) 0
          (= guesses [:r :s]) 2
          (= guesses [:s :r]) 1
          (= guesses [:r :l]) 2
          (= guesses [:l :r]) 1
          (= guesses [:o :s]) 2
          (= guesses [:s :o]) 1
          (= guesses [:l :p]) 2
          (= guesses [:p :l]) 1
          (= guesses [:o :r]) 2
          (= guesses [:r :o]) 1
          (= guesses [:r :p]) 2
          )))

(defn letsplay []
  (let [ai-guess (rand-nth [:r :p :s :l :o])
        human-guess (get-input)
        win (win ai-guess human-guess)]
    (println "Your guess" human-guess)
    (println "Opponents guess" ai-guess)
    (cond
      (= human-guess nil) (println "Invalid entry! You must choose r, p, s, l, o!")
      (= win 0) (println "Game tied.")
      (= win 1) (println "You win!")
      (= win 2) (println "You lose! :( "))))

(loop []
  (letsplay))
