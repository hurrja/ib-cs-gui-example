public class Application implements Runnable
{
  public void run ()
  {
    new GUI (this);
    state = false;
  }

  public boolean flipState ()
  {
    state = !state;
    return state;
  }

  boolean getState () { return state; }

  private boolean state;
}
