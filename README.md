# Projet-Jeux-de-carte
Ce projet codé en Java est un jeu de cartes, plus particulièrement le jeu de carte "Tu n'y peux rien".

Règles du jeux:

  Jeu composé de 54 cartes (1 2 3 4 5 6 7 8 9 10 V D R de 4 couleurs différentes ♥ ♦ ♣ ♠ + 2
  JOKERS ). On utilise ces cartes pour créer des combinaisons de jeu, on y joue 2 à 4 joueurs.
  Chaque manche tous les joueurs pioche une carte. 
  La partie se termine lorsqu’un joueur réussi à se débarrasser de l’entièreté de ce qu’il a en
  main, pour y parvenir les joueurs doivent utiliser des combinaisons de cartes. 

  Les différentes cartes ainsi que leurs degré de puissance et leurs particularités:

    Parmi les 54 cartes dans cet ordre de puissance 3 4 5 6 7 8 9 10 V D R 1 2 et la carte Joker
    pouvant être utilisée comme.
  
   Les différentes combinaisons possibles jouables par ordre de puissance:
  
    -Single : Le joueur joue une seule carte, exemple : 3 , 7 , V
    -Double : Le joueur joue 2 cartes identiques, exemple : 5/5 , D/D
    -Série : Le joueur joue une suite de minimum 3 cartes, exemple : 9/10/V , 4/5/6/7
    -Bombe : Le joueur joue un minimum 3 cartes identiques, exemple : 3/3/3 , R/R/R/R
   
   Les différents caractères et styles de jeu des BOT: 
   
      -Équilibré : BOT qui n’a pas de style de jeu particulier mais se contente de jouer de façon
      équilibrée en essayant à la fois de chercher des combinaisons plus fortes comme de se
      débarrasser des cartes en main rapidement.
      
      -Impulsif/Mauvais perdant : BOT qui va changé de style de jeu après avoir perdu plusieurs
      manches consécutives. Il va alors arrêter de chercher à obtenir des combinaisons utiles et
      puissantes et va chercher à se débarrasser de ses cartes sans se soucier des combinaisons qu’il
      peut obtenir par la suite
      
      -Réservé : BOT qui préfère économiser ses cartes pour utiliser des combinaisons plus forte
      nécessitant moins de cartes. Il va en générale mettre du temps à poser des cartes afin de
      surprendre le reste de la partie. Une longue partie a donc plus de chance d’être en son avantage
      
      -Pressé : BOT qui va jouer une combinaison dès qu’il en a l’occasion, il veut avoir le moins de
      cartes possible dans sa main. Ne cherche pas à avoir des combinaisons de plusieurs cartes en
      priorité
    
