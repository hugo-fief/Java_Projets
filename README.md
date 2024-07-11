# PROJET JEU DE COMBAT TOUR PAR TOUR EN JAVA

## ***Developed by Hugo Fief***

```
Arborescence du Projet :
combat-game/
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
- Utiliser le pattern "Strategy" pour les différentes attaques
- Utiliser le pattern "Factory" pour la création des joueurs
- Respecter les principes SOLID pour un code maintenable et extensible