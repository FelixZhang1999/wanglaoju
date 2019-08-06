package Wanglaoju.relics;

import Wanglaoju.DefaultMod;
import Wanglaoju.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import org.apache.logging.log4j.core.Logger;

import static Wanglaoju.DefaultMod.makeRelicOutlinePath;
import static Wanglaoju.DefaultMod.makeRelicPath;

public class shaolin extends CustomRelic {

    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * Gain 1 energy.
     */
    // ID, images, text.
    public static final String ID = DefaultMod.makeID("少林六合棍");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("gun.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("gun.png"));

    private static int extraGold = 10;

    public shaolin() {
        super(ID, IMG, OUTLINE, RelicTier.SHOP, LandingSound.HEAVY);
    }

    public void onMonsterDeath(AbstractMonster m) {
        AbstractDungeon.getCurrRoom().addGoldToRewards(extraGold);
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
