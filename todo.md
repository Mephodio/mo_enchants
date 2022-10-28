# To Do
**Legend** <br>
✅ - Developed, passed tests.<br>
❎ - Developed, failed tests.<br>
🚩 - Developed, not tested.


### v1.5
- ✅ Replace all uses of `getItemEnchantmentLevel()` with `getTagEnchantmentLevel()` `Deprecated`
- ✅ Move event listeners to `Events.java`
- ✅ Optimize all helper classes, make more readable
- ✅ Go through all enchantment classes, confirm everything is correct
- ✅ Move `TotemlikeAnimationMainhandProcedure` and `TotemlikeAnimationOffhandProcedure` into its own usages
- ✅ Remove all `MCreator` traces (e.g. comments)
- ✅ Optimize `init` classes
- ✅ Put cooldown on `Panic` enchantment (8s for I, 5s, for II, maybe)
- ✅ Remove unnecessary `@Nullable Event` parameter
- ✅ Fix `Angel's Blessing` enchantment animation
- Test version and make sure it is ready for distribution
- ✅ `Panic` has a bug: if there is constant damage, game will crash (server tick loop) **Possible fixes:**
  - ✅ Move `Panic` event call to `onEntityAttacked` from `onPlayerTick`
- `Curse of Freezing` and `Curse of Boiling` don't properly check for biomes
- 🚩 Make `Density` increase gravity


### v1.6
- `Water Protection`: Damage protection from drowning, tridents, and the Aqua Slash enchantment
- Move `Aqua Slash` enchantment to use entity tags, instead of hardcode
- Add more nether mobs into `Aqua Slash` damage bonus (e.g. Strider)


### v1.6 or v1.7
- Add `@bcat's` `Reeling` enchantment
- Add `@GGGamesXDlol's` `Telekinesis` enchantment
- Add `Replenish` enchantment (see `changelog.md`)