# Réponse au README.md par Armusieaux Simon et Henry Emilie

## Test Unitaire pour Java avec JUnit

> Q.1b Pour tester ces constructeurs, nous utilisons les méthodes getX et getY. Puisque rien ne nous dit si ces deux méthodes fonctionnent correctement et assurent la véracité du test, il nous faut donc impérativement tester ces deux méthodes.

> Q.1c Lors de l'exécution du programme de test pour setY getY, nous remarquons que ces méthodes ne respectent pas la documentation. Mais également les tests avec Double.NaN ne fonctionnent pas non plus.

> Q.1d Le constructeur 3 ne prend pas en compte la création d'un MyPoint avec un point null.

## Couverture de code

> Q.2b Non, le code ne reste pas sur en étant testé par au moins un test, car il est toujours possible de ne pas avoir pris en compte des éléments particulier mais sensible.

> Q.2c Pour faire fonctionner ce test, comme pour la partie HorizontalSymetry, il faut rajouter le paramètre expected sur l'annotation @Test.

## Test d'intégration pour Java avec EasyMock ou Mockito

> Q.3a On ne peut pas tester cette opération en l'état car random renvoie toujours un nombre aléatoire, ce qui la rend impossible à tester. Il faut utiliser le principe de Mock qui permet de prévoir le comportement de la fonction et de renvoyer des résultats prédéterminés de manière à pouvoir les vérifier avec un test

