package Wanglaoju.relics;

import Wanglaoju.DefaultMod;
import Wanglaoju.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;


import static Wanglaoju.DefaultMod.makeRelicOutlinePath;
import static Wanglaoju.DefaultMod.makeRelicPath;

public class taiyangqishi extends CustomRelic {

    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * Gain 1 energy.
     */
    // ID, images, text.
    public static final String ID = DefaultMod.makeID("太阳骑士");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("taiyang.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("taiyang.png"));

    private static final int poison = 2;
    private static final int stack = 1;

    public taiyangqishi() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.MAGICAL);
    }

    // Flash at the start of Battle.
    @Override
    public void atBattleStartPreDraw() {
        flash();
        AbstractPlayer p = AbstractDungeon.player;
        AbstractMonster m = AbstractDungeon.getRandomMonster();
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(m, p, new PoisonPower(m, p, poison), stack));
    }


    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
