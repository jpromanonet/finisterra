package game.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class DebugConsole extends Table {
    protected Skin skin;
    protected Stage stage;
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
        add(new Label("FPS: 60", skin)).row();
        add(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", skin)).row();
        add(new Label("Sed in elementum sem.", skin)).row();
        add(new Label("Sed fermentum semper augue eu iaculis.", skin)).row();
        add(new Label("Etiam in ultricies turpis.", skin)).row();
        add(new Label("Curabitur dui nunc, elementum quis interdum in, commodo et arcu.", skin)).row();
        add(new Label("Vivamus vel orci ligula. Nunc ut semper mi.", skin)).row();
        //pack();
    }

    public void toggle() {
        toggle = !toggle;
        setVisible(toggle);
    }
}
