
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



## Prérequis
- Java 8+

# Version actuelle : 1.0.0.alpha

# Version 1.0.0

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
