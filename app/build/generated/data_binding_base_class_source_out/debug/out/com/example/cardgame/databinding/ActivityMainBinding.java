// Generated by view binder compiler. Do not edit!
package com.example.cardgame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cardgame.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnStartGame;

  @NonNull
  public final ImageView cardImageView;

  @NonNull
  public final RecyclerView rvPlayer1;

  @NonNull
  public final RecyclerView rvPlayer2;

  @NonNull
  public final RecyclerView rvPlayer3;

  @NonNull
  public final RecyclerView rvPlayer4;

  @NonNull
  public final TextView tvRole;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnStartGame,
      @NonNull ImageView cardImageView, @NonNull RecyclerView rvPlayer1,
      @NonNull RecyclerView rvPlayer2, @NonNull RecyclerView rvPlayer3,
      @NonNull RecyclerView rvPlayer4, @NonNull TextView tvRole) {
    this.rootView = rootView;
    this.btnStartGame = btnStartGame;
    this.cardImageView = cardImageView;
    this.rvPlayer1 = rvPlayer1;
    this.rvPlayer2 = rvPlayer2;
    this.rvPlayer3 = rvPlayer3;
    this.rvPlayer4 = rvPlayer4;
    this.tvRole = tvRole;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStartGame;
      Button btnStartGame = ViewBindings.findChildViewById(rootView, id);
      if (btnStartGame == null) {
        break missingId;
      }

      id = R.id.cardImageView;
      ImageView cardImageView = ViewBindings.findChildViewById(rootView, id);
      if (cardImageView == null) {
        break missingId;
      }

      id = R.id.rvPlayer1;
      RecyclerView rvPlayer1 = ViewBindings.findChildViewById(rootView, id);
      if (rvPlayer1 == null) {
        break missingId;
      }

      id = R.id.rvPlayer2;
      RecyclerView rvPlayer2 = ViewBindings.findChildViewById(rootView, id);
      if (rvPlayer2 == null) {
        break missingId;
      }

      id = R.id.rvPlayer3;
      RecyclerView rvPlayer3 = ViewBindings.findChildViewById(rootView, id);
      if (rvPlayer3 == null) {
        break missingId;
      }

      id = R.id.rvPlayer4;
      RecyclerView rvPlayer4 = ViewBindings.findChildViewById(rootView, id);
      if (rvPlayer4 == null) {
        break missingId;
      }

      id = R.id.tvRole;
      TextView tvRole = ViewBindings.findChildViewById(rootView, id);
      if (tvRole == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnStartGame, cardImageView,
          rvPlayer1, rvPlayer2, rvPlayer3, rvPlayer4, tvRole);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
