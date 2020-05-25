
# Objectif
**Développer un système complet et autonome d'objects connectés**

Le système est composé essentiellement de deux groupes d'éléments :
- Les composants :\
    Les composants sont subdivisés en deux catégories :
    - Les capteurs
    - Les actionneurs
- Les plugins :\
    Ce sont des petites application qui s'intègrent au système et fournissent des fonctionnalités supplémentaires.
    

**SenML est une spécification qui se veut de faciliter la représentation et le transport des données 
des capteurs sur internet.**

## Que se passe t'il si l'application redémarre ?
Il faudra réfléchir à sauvegarder des informations qui permettent de recréer le système dans le cas que celui-ci se redémarre.\
Par exemple sauvegarder pour chaque entité l'ensemble des informations nécessaire.
Il doit avoir donc une base de données spéciale pour le système.\
Ces informations doivent être au minimum.
- Pour un plugin :
    - La liste des devices pour lesquels le plugin est abonné
    - (non natif) Le dossier où se trouvent les fichiers nécessaires du plugin
- Pour un device :
    - L'ensemble des informations nécessaires permettant de reconstruire le device
    - Metadata
    - Utiliser donc la méthode `toJson()`.
    
La méthode `toJson()` appelé sur un device, retourne les information `stateless (et immutable ?)` du device. Pour avoir les informations 
d'une mesure courante en json il faudra donc appelé `device.getCurrentMeasure().toJson()`.

## Structure rapide

Tout object doit être identifiable. Ces identifiants doivent être facilement lisible par l'humain.
Ci-dessous sont les informations minimales pour identifier un object.
- `name` (Unique) : Pour ne pas clasher avec les identifiants des bases de données et des différents autres services, il est préférable
d'utiliser `name` plutôt qu'id.
- `version` : Représente la version actuelle de l'outil
- `createdAt` : La date de création de l'object
- `description` : une description courte sur l'objet.

## Comment gérer les données senML

- Il faut faire la conversion vers senML en mode lazy
    - ajouter une fonction asSenML() dans sensor qui convertit une mesure vers senML.
    - Faire attention avec les champs de base 
- Cette fonction lazy peut donc être utilisée dans plusieurs niveaux du système :
    - Affichage, Transport, etc.

## Comment gérer les données batch senML IOTSystem ?

- Au niveau du system. Pour cela il deux types fonction
     - Une fonction qui produit le batch pour plusieurs capteurs du system.\
        Cette fonction doit s'assurer de ne pas dupliquer des champs de base.
     - Une fonction qui produit le batch pour un capteur, mais sous plusieurs intervalles de temps.\
        Cette fonction doit s'assurer de ne pas dupliquer des champs de base.
- Au niveau du capteur :
    - Une fonction qui produit le batch pour ce capteur, mais sous plusieurs intervalles de temps.\
    Cette fonction doit s'assurer de ne pas dupliquer des champs de base.

## Comment gérer le transport des données ?

Get /api : retourne les informations importantes sur le système :
    - Pour chaque plugin, les détails sur son interface
    - Pour chaque capteur, les informations sur celui-ci

## Comment gérer les plugins ?

Javalin a adopté un modèle dans lequel chaque plugin a accès à app: Javalin.

L'idéal serait d'éviter que les plugins aient un accès direct aux ressources du système.
Imaginer un plugin qui a les droits pour supprimer les capteurs ou même stopper le système !

Pour cela :
- Avoir une liste des ressources à publier :
    - Stockage
    - Transport
    - Analytics ? (Un gros travail)
    
    Écrire des wrappers pour envelopper ces ressources publiables et grâces à des interfaces,
    limiter l'acces de ces ressources.
- Les plugin vont donc s'abooner à des évènements du système.
- Il faudra donc lister tous les évènements.

**Il faut trouver un trade-off entre performances et sécurité**
Si on fournit le système au plugin, les risques sur la stabilité du système augmente

## Prérequis
- Java 8+

# Version actuelle : 1.0.0.alpha

# Version 1.0.0

- L'emission des évènements doit être asynchrone.
    - Si le 'capteur' n'a pas pu émettre
    un évènement, cela ne doit pas l'empêcher de continuer son processus ?
    - En cas de réception d'une grande quantité d'évènements. Le plugin doit s'assurer le bon traitement
    des évènements.
        - Par exemples, en créant d'autres threads qui s'en occuperont.
- Tous les capteurs ont la capacité de produire des données senML.
- Tous les capteurs ont une horloge interne
- Tous les capteurs ont la capacité d'affichage (écran, display)
- Tous les capteurs produisent des données numériques (double)
- Ajoute la notion d'actuateurs.
    - À un actuateur est lié un objet qui réagit aux états de l'actuateur.
- Il existe un moyen de communication entre les devices et le système.
- Il existe un moyen de communication entre les plugins et le système et les devices.

Un plugin peut décider de s'abonner à certains types d'évènement provenant des devices.

event.on("on", () => {$Do_Something});
event.on("off", () => {$Do_Something});
event.on("update", () => {$Do_Something});

# Version 1.1.0

- Possibilité de produire des données de différents type (double, boolean, string).
- Certains capteurs sont basiques :
    - Ils n'ont pas la capacité de produire leurs données sous format senML.\
    Dans ce cas le système doit s'en occuper.
    - Ils n'ont pas d'horloge interne.\
    Dans ce cas le système doit s'en occuper.
- Ajouter un système de stockage dédié.
- Ajouter un système d'analyse dédié.
- Pouvoir sérialiser le système en entier (capteurs, mesures, configurations, etc.).
- Un système peut avoir des sous systèmes.
- Réfléchir à une meilleure technologie pour le multi-threading et le scheduling.\
- Il existe deux types de plugins
    - Les plugins qui nécessitent des droits admins\
    Ces plugins ont accès à toute l'interface du système y compris les devices
    Peut éteindre et redémarré le système et les capteurs.
    - Les plugins qui n'ont pas de droits d'accès.\
    Ces plugins ne peuvent pas agir directement sur les contrôles du système.
    Ces plugins reçoivent "uniquement" des données.
        - On peut penser à permettre à ces plugins de transmettre des informations au système.\
        Par exemple demander au système d'éteindre un capteur donné parce que le plugin a reçu une donnée anormale.
Voir [Quartz Scheduling](http://www.quartz-scheduler.org/).
