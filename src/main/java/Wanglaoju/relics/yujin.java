package Wanglaoju.relics;

import Wanglaoju.DefaultMod;
import Wanglaoju.cards.AbstractDynamicCard;
import Wanglaoju.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardSave;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.UpgradeShineEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;

import javax.smartcardio.Card;

import java.util.ArrayList;

import static Wanglaoju.DefaultMod.makeRelicOutlinePath;
import static Wanglaoju.DefaultMod.makeRelicPath;

public class yujin extends CustomRelic {

    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * Gain 1 energy.
     */
    // ID, images, text.
    public static final String ID = DefaultMod.makeID("大块余烬");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("yujin.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("yujin.png"));

    public yujin() {
        super(ID, IMG, OUTLINE, RelicTier.BOSS, LandingSound.SOLID);
    }

    public void onEquip() {
        flash();
        AbstractPlayer p = AbstractDungeon.player;
        ArrayList<AbstractCard> deck = p.masterDeck.getUpgradableCards().getAttacks().group;
        float offset = 0;
        for (AbstractCard card : deck) {
            card.upgrade();
            AbstractDungeon.player.bottledCardUpgradeCheck(card);
            AbstractDungeon.effectsQueue.add(new UpgradeShineEffect((float) Settings.WIDTH / 4.0F + offset, (float) Settings.HEIGHT / 2.0F));
            AbstractDungeon.effectsQueue.add(new ShowCardBrieflyEffect(card.makeStatEquivalentCopy(), (float) Settings.WIDTH / 4.0F + offset, (float) Settings.HEIGHT / 2.0F));
            offset += Settings.WIDTH / deck.size() / 1.5;
        }
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
