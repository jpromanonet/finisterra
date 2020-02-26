## [0.1-alpha] - 8/1/2019

### Added
- Lobby & Rooms (#18)
- Balance + footprint system (#19)(#20)

### Changed
- Rearranged modules. Implemented TileMap generator.

### Removed
- Removed temporarily Archier until it's fully implemented.

### Fixed
- Can't atack yourself.
- Minor bugs.

## [0.1.1-alpha] - 24/1/2019

### Fixed
- Minor bugs.

## [0.1.2] - 24/1/2019

### Fixed
- Resolution issues.

## [0.1.3] - 2/5/2019

### Added
- New arrow cursor.
- Console messages.

### Changed
- Moved shared resources to shared module. Added design module.

### Fixed
- NPE in MagicCombatSystem.

## [0.1.4] - 4/5/2019

### Added
- TimeSync (RTT server -> client)
- Timestamp to footprint.
- Window is resizeable and correctly scaled.
- Zoom + lights
- Sync time every 60 seconds.

### Changed
- Improved messages and combat system.

### Fixed
- Resolution issues.

## [0.1.5] - 8/5/2019

### Added
- Meditar.

### Changed
- Optimized imports and code format.
- Refactored rendering systems.

### Fixed
- Minor bugs.

## [0.1.6] - 15/5/2019

### Added
- Loading and Handling Sounds (#25)
- 3D sounds.
- Function to scale graphics to 2x.
- Alkon maps are back :)
- Kotlin plugin to design subproject. (#27)
- Music handling. (#26)

### Changed
- Managers are systems now.

### Fixed
- Map and world rendering issues. (#28)

## [0.1.7] - 17/5/2019

### Fixed
- NPE when trying to fade out music.
- FX's rendering issues.

## [0.1.8] - 20/5/2019

### Added
- Energy regeneration system. (#31)
- NPC's. (#32)
- FX's loops.

### Changed
- Load all mp3/mid files in classpath.
- Refactored fffects rendering. (#33)

### Removed
- FX notification and related systems.

## [0.1.10] - 19/6/2019

### Added
- Particle positions.
- Buff system with agility and strength. (#43)
- Graphics 2x + bugfixes. (#47)
- NPC attack system.
- Notify buff changes.
- Buff GUI indicator. (#49)

### Changed
- Buff time left is now synced with server time.
- NPC's and objects in map are initialized.

### Fixed
- Build script (shared subproject).

### Removed
- Unwanted map.

## [0.1.11] - 13/7/2019
### Added
- OpenJDK's JPackage utility to bundle the game.
- Tooltip messages to spells.
- Press ENTER to login.
- Client configuration file (Config.json)
- Brand new UI.
- Training system.
- Gradle plugins DSL in subprojects.
- Minor code improvements.

### Changed
- Now graphics are loaded on-demand.
- Server now displays initialization elapsed time in second and with it's absolute value.
- Show connectionTable by default and removed some hardcoding.
- Set compiler's default encoding to UTF-8.
- Gradle wrapper version 5.4.1 -> 5.5
- JDK 8 -> 12

### Fixed
- 2x-scaled graphics.
- Rendering issues.
- Unchecked warnings & redundancies.

## [0.1.12] - 15/10/2019
### Added
- Screenshots with F2. (#132 )
- Server configuration file (Server.json). (#136 )
- Fullscreen support. (#166 )
- Lista de servidores en la pantalla de inicio de sesión. (#154 )
- Nuevo ícono de ventana. (#165 )
- Soporte multi-lenguaje. (#170 )
- Nueva barra circular de experiencia. (#206 )
- Implementado sistema de combate a distancia junto con la clase nueva Arquero. (#214 )
- Creamos el Game Design Center [Explorar](https://github.com/ao-libre/ao-java/blob/master/design/readme.md)
	-> Integramos un Map Editor
	-> Integramos visor y editor de Armas, Cascos, Escudos, Hechizos, Npc, Animaciones, Armas, Efectos, Cuerpos, Cabezas
	-> Arrastrando y soltando indexamos cualquier archivo seteado en columnas y filas simetricas.
	-> Arrastrando y soltando creamos un tile set
- Add scroll size to avoid UI creation OutOfBounds.
- NPC drops.
	
### Changed
- Mejoras al sistema de combate mágico y se arreglaron los caracteres inválidos. (#139 )
- More improvements in the fonts system. (#144 )
- Actualizaciones varias de parámetros de inicio. (#148 )
- Convertimos todos los recursos a json (mapas, hechizos, cuerpos, cabezas, armas, animaciones, objetos)
- Limitada creación de salas mediante Server.json. (#219 )
- Limite de personajes conectados en una sala mediante Server.json. (#223 )
- Refactoreo el procedimiento de empaquetado del juego de JPackage.
- Precargamos la primera capa del mapa y la guardamos en cache.
- Mejoras menores en subproyecto design.

### Fixed
- Level-up doesn't give more HP. (#141 )
- NPE when creating GUI view. (#162 )
- Elección aleatoria de clase al crear un personaje. (#224 )
- NPE al inicializar subproyecto design.
- FX's ID's.

## [0.1.13] - 14/12/2019
### Added
- Hechizo para invocar mascotas con su ícono. (#231 )
- Implementación basica de comandos en consola. (#251 )
- Nuevo sistema de logeo de errores, se crea un archivo `Errores.log` con los datos del mismo en la carpeta del ejecutable. (#263 )
- Al pasar el mouse por los items en el Inventario te muestra su información. (#259 )

### Changed
- El usar proyectiles consume energía. (#240 )
- Se refactorizó el sistema de audio y se solucionaron todos los errores que tenía. (#245 y #246 )
- Se mejoró el mensaje en consola al clickear un objeto. (#249 )
- JDK 12 -> 13. (#265 )

### Fixed
- Se arregló un error al guardar un screenshot y prevenimos que crashee el juego en caso de haber un error. (#264 )
