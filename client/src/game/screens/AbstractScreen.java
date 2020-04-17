package game.screens;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import game.utils.Resources;
import game.utils.Skins;
import net.mostlyoriginal.api.system.core.PassiveSystem;

public abstract class AbstractScreen extends PassiveSystem implements Screen {
    private static final Skin SKIN = Skins.COMODORE_SKIN;
    private static final Texture BACKGROUND_TEXTURE = new Texture(Gdx.files.internal(Resources.GAME_IMAGES_PATH + "background.jpg"));
    private static final SpriteDrawable BACKGROUND = new SpriteDrawable(new Sprite(BACKGROUND_TEXTURE));

    private final Stage stage;
    private Table mainTable;

    public AbstractScreen() {
        stage = new Stage() {
            @Override
            public boolean keyUp(int keyCode) {
                keyPressed(keyCode);
                return super.keyUp(keyCode);
            }
        };
    }

    @Override
    public void show() {
        mainTable = new Table(SKIN);
        mainTable.setFillParent(true);
        mainTable.setBackground(BACKGROUND);
        stage.addActor(mainTable);
        createUI();
        Gdx.input.setInputProcessor(getStage());
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        //do nothing
    }

    @Override
    public void resume() {
        //do nothing
    }

    @Override
    public void hide() {
        //do nothing
    }

    /**
     * <b>Nota:</b> Este método implementa al mismo tiempo:
     * {@link BaseSystem#dispose()} de Artemis
     * {@link Screen#dispose()} de libGDX
     */
    @Override
    public void dispose() {
        stage.dispose();
    }

    protected abstract void createUI();

    protected void keyPressed(int keyCode) {
        //do nothing
    }

    public Stage getStage() {
        return stage;
    }

    public Table getMainTable() {
        return mainTable;
    }

    public Skin getSkin() {
        return SKIN;
    }
}
