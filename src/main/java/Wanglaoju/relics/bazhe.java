package Wanglaoju.relics;

import Wanglaoju.DefaultMod;
import Wanglaoju.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static Wanglaoju.DefaultMod.makeRelicOutlinePath;
import static Wanglaoju.DefaultMod.makeRelicPath;

public class bazhe extends CustomRelic {

    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * 受到的伤害 * 2
     */
    // ID, images, text.
    public static final String ID = DefaultMod.makeID("霸者契约");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("bazhe.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("bazhe.png"));

    public bazhe() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.MAGICAL);
    }


    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        flash();
        return damageAmount * 2;
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
