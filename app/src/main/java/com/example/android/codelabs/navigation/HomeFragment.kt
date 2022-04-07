/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

/** Fragment used to show how to navigate to another destination */
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
        TODO STEP 5 - Set an OnClickListener, using Navigation.createNavigateOnClickListener();
        val button = view.findViewById<Button>(R.id.navigate_destination_button)
        button?.setOnClickListener {
        findNavController().navigate(R.id.flow_step_one_dest, null)
        }

        este es el mio, el de arriba no funciona no se por que saca error en la declaracion de button
         val button = view.findViewById<Button>(R.id.navigate_destination_button)
        button?.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null)
        }
        */
        /*  val button = view.findViewById<Button>(R.id.navigate_destination_button)
          button?.setOnClickListener {
              Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest, null)
          }*/

        //TODO END STEP 5
        //vamos a hacer que con el boton navigate_destination_button pase de la primera pantalla a la segunda pantalla
        //este es el que me funciona ami, no se por que pero toca escribirlo, no lo coje con copiar y pegar
        /* val button = view.findViewById<Button>(R.id.navigate_destination_button)
         button?.setOnClickListener {
             findNavController().navigate(R.id.flow_step_one_dest, null)
         }*/


        /*
        TODO STEP 6 - Set NavOptions
        val options = navOptions {
        anim {
        enter = R.anim.slide_in_right
        exit = R.anim.slide_out_left
        popEnter = R.anim.slide_in_left
        popExit = R.anim.slide_out_right
        }
        }
        view.findViewById<Button>(R.id.navigate_destination_button)?.setOnClickListener {
        findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }
        TODO END STEP 6*/
        //transicion personalizada, pasa a la siguiente pantalla deslizandola a la izquierda y presionanado atraz se devuelve deslizandose
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        view.findViewById<Button>(R.id.navigate_destination_button)?.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }

        /* TODO STEP 7.2 - Update the OnClickListener to navigate using an action
         view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
         Navigation.createNavigateOnClickListener(R.id.next_action, null)
         )
         TODO END STEP 7.2
         */
      /* //se agrega un objeto de escucha de clicks al navegate_action_button
        view.findViewById<Button>(R.id.navigate_action_button)
            ?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action, null))*/

      //podemos cambiar el objeto de escucha de clicks por este segun el paso 8 del codelab
        // Note the usage of curly braces since we are defining the click listener lambda
        view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener {
            val flowStepNumberArg = 1
            val action = HomeFragmentDirections.nextAction(flowStepNumberArg)
            findNavController().navigate(action)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
