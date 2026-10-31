# Begleiter – clientseitige Minecraft-Mod (Fabric 1.21.1)

Ein Begleiter läuft dir hinterher, redet mit dir, kann den Skin von jedem
Minecraft-Account übernehmen und hat einen **Tsundere-Modus** mit Geräuschen.

Die Mod ist **rein clientseitig**: Der Begleiter existiert nur bei dir.
Sie funktioniert in Einzelspieler und auf Servern (andere sehen ihn nicht).

## Bedienung

| Aktion | Wirkung |
|---|---|
| **Rechtsklick** auf den Begleiter (oder Taste **G**) | Dialog öffnen |
| **Linksklick** auf den Begleiter | Er/sie ist beleidigt (Zuneigung −1) |
| Taste **K** | Einstellungen |

**Einstellungen (K):**
- Name des Begleiters
- Minecraft-Name für den Skin → **Laden** (holt den Skin über die Mojang-API, inkl. Slim/Alex-Modell)
- Tsundere-Modus an/aus
- Begleiter aktiv, Folgt mir, spontanes Gerede
- Begleiter zu dir holen, Zuneigung zurücksetzen

Die Einstellungen werden in `config/begleiter.json` gespeichert.

## Features
- Folgt dir, sprintet wenn du weit weg bist, springt über Blöcke, schwimmt,
  teleportiert sich zu dir ab 24 Blöcken Entfernung, schleicht mit dir
- Dialogbaum: Wie geht's? / Über dich / Kompliment / Magst du mich? /
  Was sollen wir machen? / Geschenk (Item in der Hand) / Warte hier – Komm mit / Tschüss
- **Zuneigungssystem**: Komplimente und Geschenke erhöhen sie, Schläge senken sie.
  Im Tsundere-Modus wird der Begleiter mit steigender Zuneigung immer „dere-iger“.
- Spontane Reaktionen: wenn du Schaden nimmst, bei wenig Leben, bei Einbruch der Nacht
  und ab und zu einfach so
- Tsundere: Starrst du ihn/sie zu lange an, wird er/sie rot und dreht sich weg
- Geräusche (Hmpf, wütend, verlegen, fröhlich, traurig)

Hinweis: Weil die Mod clientseitig ist, bleiben verschenkte Items in deinem Inventar.

## Eigene Stimme / Geräusche
Standardmäßig nutzt die Mod hochgepitchte Vanilla-Sounds. Mit einem Ressourcenpaket
kannst du sie durch eigene `.ogg`-Dateien ersetzen: Lege
`assets/begleiter/sounds.json` (gleiche Schlüssel wie in der Mod: `voice.hmph`,
`voice.angry`, `voice.embarrassed`, `voice.happy`, `voice.sad`, `voice.talk`) mit
`"replace": true` und deine Dateien unter `assets/begleiter/sounds/...` an, z. B.:

```json
{ "voice.hmph": { "replace": true, "sounds": ["begleiter:hmph1", "begleiter:hmph2"] } }
```

## Bauen
Voraussetzung: **Java 21** (JDK).

```bash
./gradlew build
```

Die fertige Mod liegt dann unter `build/libs/begleiter-1.0.0.jar`. Kopiere sie zusammen mit
der **Fabric API** in deinen `mods`-Ordner (Fabric Loader für 1.21.1 installieren).

Zum direkten Testen: `./gradlew runClient`

Falls eine Abhängigkeitsversion nicht gefunden wird, trage auf
https://fabricmc.net/develop die aktuellen Versionen für 1.21.1 in `gradle.properties` ein.
