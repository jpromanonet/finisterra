package game.ui;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class DebugConsole extends Table {
    static public String fps;

    protected Skin skin;
    protected Label fpsLabel;
    protected boolean toggle;

    public DebugConsole(Skin skin) {
        super(skin);
        this.skin = skin;
        toggle = false;
        setDebug(true);
        setFillParent(true);
        setVisible(false);
        top().left();
        create();
    }

    public void create() {
        defaults().left();
        fpsLabel = new Label(fps, skin);
        add(fpsLabel).row();
        add(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", skin)).row();
        add(new Label("Sed in elementum sem.", skin)).row();
        add(new Label("Sed fermentum semper augue eu iaculis.", skin)).row();
        add(new Label("Etiam in ultricies turpis.", skin)).row();
        add(new Label("Curabitur dui nunc, elementum quis interdum in, commodo et arcu.", skin)).row();
        add(new Label("Vivamus vel orci ligula. Nunc ut semper mi.", skin)).row();
        //pack();
    }

    @Override
    protected void setParent(Group parent) {
        super.setParent(parent);
        setZIndex(999);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fpsLabel.setText(fps);
    }

    public void toggle() {
        toggle = !toggle;
        setVisible(toggle);
    }
}
