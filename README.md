# PROJET JEU DE COMBAT TOUR PAR TOUR EN JAVA

## ***Developed by Hugo Fief***

```
Arborescence du Projet :
fight_game/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── mygame/
│   │   │   │   │   ├── Game.java
│   │   │   │   │   ├── battle/
│   │   │   │   │   │   ├── Battle.java
│   │   │   │   │   ├── player/
│   │   │   │   │   │   ├── Player.java
│   │   │   │   │   │   ├── PlayerFactory.java
│   │   │   │   │   ├── strategy/
│   │   │   │   │   │   ├── AttackStrategy.java
│   │   │   │   │   │   ├── NormalAttack.java
│   │   │   │   │   │   ├── SpecialAttack.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── mygame/
│   │   │   │   │   ├── GameTest.java
│   │   │   │   │   ├── battle/
│   │   │   │   │   │   ├── BattleTest.java
│   │   │   │   │   ├── player/
│   │   │   │   │   │   ├── PlayerTest.java
│   │   │   │   │   │   ├── PlayerFactoryTest.java
│   │   │   │   │   ├── strategy/
│   │   │   │   │   │   ├── AttackStrategyTest.java
│   │   │   │   │   │   ├── NormalAttackTest.java
│   │   │   │   │   │   ├── SpecialAttackTest.java
```

Bonnes pratiques de Développement :
- Utilisation du pattern "Strategy" pour les différentes attaques
- Utilisation du pattern "Factory" pour la création des joueurs
- Respect des principes SOLID pour un code maintenable et extensible

Force du projet :
Configuration Maven : Utilisation de Maven pour la gestion des dépendances et l'organisation du projet.
Logging avec SLF4J et Logback : Utilisation de SLF4J pour des logs propres et professionnels.
Ajout de probabilités d'attaque : Introduction de la logique de succès/échec des attaques pour rendre le jeu plus intéressant.
Coloration des logs : Utilisation de la bibliothèque Jansi pour ajouter des couleurs aux messages de log, améliorant ainsi la lisibilité.