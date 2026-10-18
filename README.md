# Cobblemon Catch Rate Display — Fabric 1.20.1 Backport

An unofficial Fabric 1.20.1 backport of [Cobblemon Catch Rate Display](https://github.com/Akkiruk/catchrate-display), the MIT-licensed client mod by Akkiruk. It carries the original catch-rate HUD, ball comparison panel, configurable keybinds, world-target display, and debug tools onto Cobblemon 1.5.2.

## Compatibility

| Component | Supported version |
| --- | --- |
| Minecraft | 1.20.1 |
| Fabric Loader | 0.16.10 or newer |
| Fabric API | 0.92.6+1.20.1 or newer |
| Fabric Language Kotlin | 1.12.3 or newer |
| Cobblemon | 1.5.2 |

The mod is client-side. The server does not need to install it.

## Features

- Shows estimated catch chance, HP, status, and ball effects during a Cobblemon battle.
- Compares Poké Balls by catch chance while holding **G**.
- Checks nearby wild Pokémon outside battle when that display is enabled.
- Offers nine HUD anchor positions, configurable keybinds, and a visibility toggle (**K**).
- Provides `/catchrate debug` and `/catchrate info` client commands.

## Installation

Install the Fabric 1.20.1 file alongside Fabric API, Fabric Language Kotlin, and Cobblemon 1.5.2. The file belongs in the client `mods` folder; it is not required on the server.

## 1.20.1 compatibility note

Cobblemon 1.5.2 does not expose synchronized Pokédex knowledge to client mods. If the port cannot infer a Repeat Ball condition, it labels the prediction as an estimate. The “hide unencountered Pokémon” option fails open because that data is unavailable. Other catch-rate inputs are read from the 1.20.1 Cobblemon registry and battle state.

## Build

This branch builds the Fabric 1.20.1 target:

```bash
./gradlew :fabric:build
```

The release jar is written to `fabric/build/libs/`.

## Test status

This is an alpha backport. A client smoke test on Minecraft 1.20.1 with Fabric Loader 0.16.10 and Cobblemon 1.5.2 loaded the mod and its assets without a mod-caused crash. Testing stopped before entering a world; the battle HUD, in-world calculations, keybinds, and longer-session behavior still need validation.

## License and attribution

The port is distributed under the original MIT license in [LICENSE](LICENSE). The original project and author remain credited at [Akkiruk/catchrate-display](https://github.com/Akkiruk/catchrate-display). This unofficial backport is not affiliated with or endorsed by Akkiruk or the Cobblemon team.

AI disclosure: AI tools were used to prepare this unofficial backport; the original author and MIT license are credited above.
